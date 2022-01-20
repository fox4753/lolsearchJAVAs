package com.Prac.model;

public class SummonerVO {
	private int iconid;
	private String name;
	private int level;
	private String puuid;

	public SummonerVO() {
		
	}
	
	public SummonerVO(int iconid, String name, int level, String puuid) {
		this.iconid = iconid;
		this.name = name;
		this.level = level;
		this.puuid = puuid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getIconid() {
		return iconid;
	}
	public void setIconid(int iconid) {
		this.iconid = iconid;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	@Override
	public String toString() {
		return "SummonerVO [iconid=" + iconid + ", name=" + name + ", level=" + level + ", puuid=" + puuid + "]";
	}
	
	
}
