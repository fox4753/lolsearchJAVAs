package com.Prac.controller;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;
import com.Prac.model.ChampionVO;
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
			
			
			temp = new SummonerVO(iconid, name, level);
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("summoner", temp);
		model.addAttribute("iconURL",
				"http://ddragon.leagueoflegends.com/cdn/12.1.1/img/profileicon/"
				+temp.getIconid()+".png");
		
		return "lol/PlayerLevel";
	}

	


}



