package com.Prac.model;

public class ChampionVO implements Comparable<ChampionVO> {
 String name;
 String id;
 int key;
 
 public ChampionVO(){
	 
 }
 
 public ChampionVO(String name,String id, int key) {
	 this.name = name;
	 this.id = id;
	 this.key = key;
	 
 }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public int getKey() {
	return key;
}

public void setKey(int key) {
	this.key = key;
}

@Override
public String toString() {
	return String.format("ChampionVO [name=%s, id=%s, key=%s]", name, id, key);
}

@Override
public int compareTo(ChampionVO o) {
	return this.name.compareTo(o.name);
}

 
}
