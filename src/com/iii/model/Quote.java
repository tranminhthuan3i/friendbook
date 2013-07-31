package com.iii.model;

import java.io.Serializable;

import android.graphics.Bitmap;

public class Quote implements Serializable{
	private String quoteEng;
	private String quoteVn;
	private String author;
	
	public Quote( String quoteEng,String quoteVn,String author) {
		super();
		this.quoteEng = quoteEng;
		this.quoteVn = quoteVn;
		this.author = author;
	}

	
	public String getQuoteEng() {
		return quoteEng;
	}


	public void setQuoteEng(String quoteEng) {
		this.quoteEng = quoteEng;
	}


	public String getQuoteVn() {
		return quoteVn;
	}


	public void setQuoteVn(String quoteVn) {
		this.quoteVn = quoteVn;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	
}
