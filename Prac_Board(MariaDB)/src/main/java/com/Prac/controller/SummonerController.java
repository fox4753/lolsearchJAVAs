package com.Prac.controller;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Prac.model.ChampionVO;
import com.Prac.model.MatchdataVO;
import com.Prac.model.SummonerVO;


@Controller
public class SummonerController {
	
	private static final Logger log = LoggerFactory.getLogger(SummonerController.class);
	final static String API_KEY = "YOUR_KEY";
	/* 메인 및 매주 로테이션 */ 
	@RequestMapping("/")
	public String lolMain(Model model) {
	
		ChampionVO datatemp = null;
		ArrayList<ChampionVO> resultarr = new ArrayList<>();
		
	try {
		
		String urlstr ="https://kr.api.riotgames.com/lol/platform/v3/champion-rotations"+
				"?api_key="+API_KEY;
		BufferedReader br = null;
		URL url = new URL(urlstr);
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
		String result ="";
		String line;
		while((line = br.readLine()) != null) {
			result = result +  line;
		}
		JSONParser jsonParser = new JSONParser();
		JSONObject jobj = (JSONObject)jsonParser.parse(result);
		JSONArray arr = (JSONArray)jobj.get("freeChampionIds");
		

		JSONParser parser = new JSONParser();
		Reader reader = new FileReader("E:\\test\\champion.json");
		
		Object obj = parser.parse(reader);
		
		JSONObject jsonObject = (JSONObject)obj;
		JSONObject dataJsonObject = (JSONObject) jsonObject.get("data");
		
		//All keys
		
		Set<String> keys = dataJsonObject.keySet();
		

		for(String key : keys) {
			JSONObject jsonKey = (JSONObject)dataJsonObject.get(key);
			String keyJsonObject = (String) jsonKey.get("key");
			String nameJsonObject = (String) jsonKey.get("name");
			String idJsonObject = (String) jsonKey.get("id");
			int maxChampion = keys.size(); 
			
			for(int i = 0; i < arr.size(); i++) {		
				//equals 비교를위해 Long인 JSONArray를 String으로 변환
				String namearr = (String) Long.toString((Long) arr.get(i));
					if(keyJsonObject.equals(namearr)) {
						
						String chamname = nameJsonObject;
						String chamid = idJsonObject;
						int chamkey = Integer.parseInt(keyJsonObject);
						
						datatemp = new ChampionVO(chamname, chamid, chamkey);
						
						
						
						//System.out.println("챔피언코드 == > " + idJsonObject);
						//System.out.println("챔피언이름 == > " + nameJsonObject);
						//System.out.println("챔피언키 == > " + keyJsonObject);
						resultarr.add(datatemp);
					}
				}	
			}
		/*
		for(ChampionVO str : resultarr) {
			System.out.println(str);
		}
		*/
		//로테이션 날짜 
		LocalDate now = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		Calendar calend = Calendar.getInstance();
		calend.setTime(new Date());
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("MM-dd");
		
		
		calend.add(Calendar.DATE, 7);
		String rotatTime = df.format(cal.getTime());
		String rotatendTime = df.format(calend.getTime());
		
		Collections.sort(resultarr);
		model.addAttribute("rotatTime", rotatTime);
		model.addAttribute("rotatendTime", rotatendTime);
		model.addAttribute("info", resultarr);
		
	}catch(Exception e) {
		System.out.println("오류 : "+e.getMessage());
	}
		
		return "lol/lolmain";
	}
	
	
	
	/* 소환사 이름 검색 */ 
	@RequestMapping(value="/SummonerInfo", method=RequestMethod.GET)
	public String searchSummoner(Model model, HttpServletRequest request) {
		BufferedReader br = null;
		String SummonerName = request.getParameter("sname");
		SummonerVO temp = null;
		MatchdataVO matchData = null;
		ArrayList<MatchdataVO> resultarr = new ArrayList<>();
		
		try {
			String urlstr ="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
					SummonerName +"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result ="";
			String line;
			while((line = br.readLine()) != null) {
				result = result +  line;
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject ob = (JSONObject) jsonParser.parse(result);
			System.out.println("=================");
			System.out.println(ob);
			String name = (String) ob.get("name");
			System.out.println(name);
			
			int level = ((Long) ob.get("summonerLevel")).intValue();
			System.out.println(level);
			
			int iconid = ((Long) ob.get("profileIconId")).intValue();
			System.out.println(iconid);
			
			String summonerid = (String) ob.get("id");
			System.out.println(summonerid);
			
			String puuid = (String) ob.get("puuid");
			System.out.println(puuid);
			
			temp = new SummonerVO(iconid, name, level, puuid);
			
			
			//소환사 매치 검색
			String urlstr2 ="https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+
					"/ids?start=0&count=5&api_key="+ API_KEY;
			
			URL url2 = new URL(urlstr2);
			HttpURLConnection urlconnection2 = (HttpURLConnection) url2.openConnection();
			urlconnection2.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection2.getInputStream(), "UTF-8"));
			String result2 ="";
			String line2;
			while((line2 = br.readLine()) != null) {
				result2 = result2 +  line2;
			}
			//JSONArray 객체이름이없으면 JSONObject를 사용하지않고 Array로파싱 
			
			
			JSONArray obj = (JSONArray) jsonParser.parse(result2);
			
			for(int i = 0; i  < obj.size()  ; i++ ) {
			
			String matchid = (String) obj.get(i);
			String matchurlstr ="https://asia.api.riotgames.com/lol/match/v5/matches/" + matchid + "?api_key="+ API_KEY;
			URL matchDataurl = new URL(matchurlstr);
			HttpURLConnection matchdataconn = (HttpURLConnection) matchDataurl.openConnection();
			matchdataconn.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(matchdataconn.getInputStream(), "UTF-8"));
			String matchdata = "";
			String line3;
			while((line3 = br.readLine()) != null) {
				matchdata = matchdata + line3;
			}

			
			
			
			
			
			Object obj3 = jsonParser.parse(matchdata);
			JSONObject JsonObject = (JSONObject) obj3;
			JSONObject dataJsonObject = (JSONObject) JsonObject.get("info");
			
			JSONArray arr = (JSONArray)dataJsonObject.get("participants");
			//summonerName
			//Set<String> keys = datajson.keySet();
			System.out.println(arr);
			if (arr.size() > 0 ) {
				for(int j = 0; j<arr.size(); j++) {
					JSONObject namedataobj = (JSONObject)arr.get(j);
					String namedata = (String)namedataobj.get("summonerName");
					Long killsdata = ((Long)namedataobj.get("kills"));
					Long deathsdata = ((Long)namedataobj.get("deaths"));
					Long assistsdata = ((Long)namedataobj.get("assists"));
					Long item0 = ((Long)namedataobj.get("item0"));
					Long item1 = ((Long)namedataobj.get("item1"));
					Long item2 = ((Long)namedataobj.get("item2"));
					Long item3 = ((Long)namedataobj.get("item3"));
					Long item4 = ((Long)namedataobj.get("item4"));
					Long item5 = ((Long)namedataobj.get("item5"));
					Long item6 = ((Long)namedataobj.get("item6"));
					boolean winlose = (boolean)namedataobj.get("win");
					String chamName = ((String)namedataobj.get("championName"));
					if(namedata.equals(name)) {
						System.out.println("본인확인  : " + namedata);
						
						System.out.println("플레이 캐릭터 : " + (String)namedataobj.get("championName") );
					
					
						System.out.println("킬 : " + killsdata);
						System.out.println("데스 : " + deathsdata );
						System.out.println("어시 : " + assistsdata);
						temp = new SummonerVO(iconid, name, level, puuid);
						matchData = new MatchdataVO (namedata, chamName, winlose, killsdata,  deathsdata, assistsdata,item0, item1, item2, item3, item4, item5, item6);
					
						resultarr.add(matchData);
					}
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("info", resultarr);
		model.addAttribute("matchdata", matchData);
		model.addAttribute("summoner", temp);
		model.addAttribute("iconURL",
				"http://ddragon.leagueoflegends.com/cdn/12.3.1/img/profileicon/"
				+temp.getIconid()+".png");

		
		return "lol/PlayerLevel";
	}


	


}



