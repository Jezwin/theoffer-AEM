package com.auki.core.models;

public class OfferModel {
	
	private String imagePath;
	private String title;
	private String description;
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OfferModel(String imagePath, String title, String description) {
		super();
		this.imagePath = imagePath;
		this.title = title;
		this.description = description;
	}
	
	

}
