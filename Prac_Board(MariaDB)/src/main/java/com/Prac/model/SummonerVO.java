package com.Prac.model;

public class SummonerVO {
	private int iconid;
	private String name;
	private int level;

	public SummonerVO() {
		
	}
	
	public SummonerVO(int iconid, String name, int level) {
		this.iconid = iconid;
		this.name = name;
		this.level = level;
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
	@Override
	public String toString() {
		return "SummonerVO [name=" + name + ", level=" + level + ", iconid=" + iconid + "]";
	}
	
	
}
