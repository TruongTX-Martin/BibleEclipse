package com.truongtechno.bible.entity;

public class ItemCuuUoc {

	private String name;
	private String path;

	public ItemCuuUoc(String name,String path) {
		this.name = name;
		this.path = path;
	}
	public ItemCuuUoc() {
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
