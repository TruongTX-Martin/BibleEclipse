package com.truongtechno.bible.entity;

public class ItemBible {

	private String name;
	private String path;

	public ItemBible() {
		// TODO Auto-generated constructor stub
	}
	public ItemBible(String name,String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
