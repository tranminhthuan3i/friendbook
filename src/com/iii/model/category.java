package com.iii.model;

import java.io.Serializable;

import android.graphics.Bitmap;

public class category implements Serializable{
	private String name;
	private String stt;
	private Bitmap imageview;
	
	public category( String name,String stt, Bitmap imageview) {
		super();
		this.name = name;
		this.stt = stt;
		this.imageview = imageview;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public Bitmap getImageview() {
		return imageview;
	}
	public void setImageview(Bitmap imageview) {
		this.imageview = imageview;
	}
	
	
	
	
	
}
