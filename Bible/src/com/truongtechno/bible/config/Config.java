package com.truongtechno.bible.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.truongtechno.bible.MainActivity;
import com.truongtechno.bible.entity.ItemBible;
import com.truongtechno.bible.entity.ItemBible;

import android.graphics.Color;
import android.util.DisplayMetrics;

public class Config {

	private static Config instance;

	private String mThemeColor = "#3498DB";
	private String section_text_color = "#000000";
	private String section_color = "#E0E0E0";
	private String key_color = "#3498DB";
	private Map<String, String> mLanguages;
	private int withScreen = 0;

	public static Config getInstance() {
		if (null == instance) {
			instance = new Config();
		}

		return instance;
	}
	
	public int getWidthScreen() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		MainActivity.context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		return width;
	}
	
	public List<ItemBible> getListTanUoc() {
		ArrayList<ItemBible> list = new ArrayList<ItemBible>();
		list.add(new ItemBible("Sáng thế ký",""));
		list.add(new ItemBible("Xuất Ê-díp-tô ký",""));
		list.add(new ItemBible("Lê-vi ký",""));
		list.add(new ItemBible("Dân số ký",""));
		list.add(new ItemBible("Phục truyền luật lệ ký",""));
		list.add(new ItemBible("Giô-suê",""));
		list.add(new ItemBible("Các quan xét",""));
		list.add(new ItemBible("Ru-tơ",""));
		list.add(new ItemBible("I Sa-mu-ên",""));
		list.add(new ItemBible("II Sa-mu-ên",""));
		list.add(new ItemBible("I Các Vua",""));
		list.add(new ItemBible("II Các Vua",""));
		list.add(new ItemBible("I Sử ký",""));
		list.add(new ItemBible("II Sử ký",""));
		list.add(new ItemBible("E-xơ-ra",""));
		list.add(new ItemBible("Nê-hê-mi",""));
		list.add(new ItemBible("Ê-xơ-tê",""));
		list.add(new ItemBible("Gióp",""));
		list.add(new ItemBible("Thi Thiên",""));
		list.add(new ItemBible("Châm ngôn",""));
		list.add(new ItemBible("Truyền đạo",""));
		list.add(new ItemBible("Nhã ca",""));
		list.add(new ItemBible("Ê-sai",""));
		list.add(new ItemBible("Giê-rê-mi",""));
		list.add(new ItemBible("Ca thương",""));
		list.add(new ItemBible("Ê-xê-chi-ên",""));
		list.add(new ItemBible("Đa-ni-ên",""));
		list.add(new ItemBible("Ô-sê",""));
		list.add(new ItemBible("Giô-ên",""));
		list.add(new ItemBible("A-mốt",""));
		list.add(new ItemBible("Áp-đia",""));
		list.add(new ItemBible("Giô-na",""));
		list.add(new ItemBible("Mi-chê",""));
		list.add(new ItemBible("Na-hum",""));
		list.add(new ItemBible("Ha-ba-cúc",""));
		list.add(new ItemBible("Sô-phô-ni",""));
		list.add(new ItemBible("A-ghê",""));
		list.add(new ItemBible("Xa-cha-ri",""));
		list.add(new ItemBible("Ma-la-chi",""));
		return list;
	}
	
	public List<ItemBible> getListCuuUoc() {
		ArrayList<ItemBible> list = new ArrayList<ItemBible>();
		list.add(new ItemBible("Ma-thi-ơ", ""));
		list.add(new ItemBible("Mác", ""));
		list.add(new ItemBible("Lu-ca", ""));
		list.add(new ItemBible("Giăng", ""));
		list.add(new ItemBible("Công vụ các Sứ đồ", ""));
		list.add(new ItemBible("Rô-ma", ""));
		list.add(new ItemBible("I Cô-rinh-tô", ""));
		list.add(new ItemBible("II Cô-rinh-tô", ""));
		list.add(new ItemBible("Ga-la-ti", ""));
		list.add(new ItemBible("Ê-phê-sô", ""));
		list.add(new ItemBible("Phi-líp", ""));
		list.add(new ItemBible("Cô-lô-se", ""));
		list.add(new ItemBible("I Tê-sa-lô-ni-ca", ""));
		list.add(new ItemBible("II Tê-sa-lô-ni-ca", ""));
		list.add(new ItemBible("I Ti-mô-thê", ""));
		list.add(new ItemBible("II Ti-mô-thê", ""));
		list.add(new ItemBible("Tít", ""));
		list.add(new ItemBible("Phi-lê-môn", ""));
		list.add(new ItemBible("Hê-bơ-rơ", ""));
		list.add(new ItemBible("Gia-cơ", ""));
		list.add(new ItemBible("I Phi-e-rơ", ""));
		list.add(new ItemBible("II Phi-e-rơ", ""));
		list.add(new ItemBible("I Giăng", ""));
		list.add(new ItemBible("II Giăng", ""));
		list.add(new ItemBible("III Giăng", ""));
		list.add(new ItemBible("Giu-đe", ""));
		list.add(new ItemBible("Khải Huyền", ""));
		return list;
	}
 
	public int getColorMain() {
		return Color.parseColor(mThemeColor);
	}

	public int getSection_text_color() {
		return Color.parseColor(section_text_color);
	}

	public void setSection_text_color(String section_text_color) {
		this.section_text_color = section_text_color;
	}

	public String getSection_color() {
		return section_color;
	}

	public void setSection_color(String section_color) {
		this.section_color = section_color;
	}

	public int getKey_color() {
		return Color.parseColor(key_color);
	}

	public void setKey_color(String key_color) {
		this.key_color = key_color;
	}

}
