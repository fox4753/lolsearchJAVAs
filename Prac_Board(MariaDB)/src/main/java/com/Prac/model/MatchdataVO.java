package com.Prac.model;

public class MatchdataVO {
	private String summonerName;
	private boolean winlose;



	private Long kills;
	private Long deaths;
	private Long assists;
	private String chamName;
	private Long item0;
	private Long item1;
	private Long item2;
	private Long item3;
	private Long item4;
	private Long item5;
	//와드
	private Long item6;
	
	public MatchdataVO() {
		
	}
	public boolean getWinlose() {
		return winlose;
	}
	public void setWinlose(boolean winlose) {
		this.winlose = winlose;
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

	

	public Long getItem0() {
		return item0;
	}



	public void setItem0(Long item0) {
		this.item0 = item0;
	}



	public Long getItem1() {
		return item1;
	}



	public void setItem1(Long item1) {
		this.item1 = item1;
	}



	public Long getItem2() {
		return item2;
	}



	public void setItem2(Long item2) {
		this.item2 = item2;
	}



	public Long getItem3() {
		return item3;
	}



	public void setItem3(Long item3) {
		this.item3 = item3;
	}



	public Long getItem4() {
		return item4;
	}



	public void setItem4(Long item4) {
		this.item4 = item4;
	}



	public Long getItem5() {
		return item5;
	}



	public void setItem5(Long item5) {
		this.item5 = item5;
	}



	public Long getItem6() {
		return item6;
	}



	public void setItem6(Long item6) {
		this.item6 = item6;
	}
	


	public String getChamName() {
		return chamName;
	}



	public void setChamName(String chamName) {
		this.chamName = chamName;
	}



	public MatchdataVO(String summonerName, String chamName,boolean winlose , Long kills, Long deaths, Long assists
			,Long item0, Long item1, Long item2, Long item3, Long item4, Long item5, Long item6) {
		this.summonerName = summonerName;
		this.chamName = chamName;
		this.winlose = winlose;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		
	}
	
	
	
}
