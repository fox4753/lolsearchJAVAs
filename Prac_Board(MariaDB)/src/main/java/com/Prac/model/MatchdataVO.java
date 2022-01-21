package com.Prac.model;

public class MatchdataVO {
	private String summonerName;
	private Long kills;
	private Long deaths;
	private Long assists;
	/*
	private Long item0;
	private Long item1;
	private Long item2;
	private Long item3;
	private Long item4;
	private Long item5;
	//와드
	private Long item6;
	*/
	public MatchdataVO() {
		
	}
	
	
	
	public String getSummonerName() {
		return summonerName;
	}



	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}



	public Long getKills() {
		return kills;
	}



	public void setKills(Long kills) {
		this.kills = kills;
	}



	public Long getDeaths() {
		return deaths;
	}



	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}



	public Long getAssists() {
		return assists;
	}



	public void setAssists(Long assists) {
		this.assists = assists;
	}



	public MatchdataVO(String summonerName, Long kills, Long deaths, Long assists) {
			//,Long item0, Long item1, Long item2, Long item3, Long item4, Long item5, Long item6) {
		this.summonerName = summonerName;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
//		this.item0 = item0;
//		this.item1 = item1;
//		this.item2 = item2;
//		this.item3 = item3;
//		this.item4 = item4;
//		this.item5 = item5;
//		this.item6 = item6;
	}
	
	
	
}
