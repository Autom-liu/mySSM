package com.scnu.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Ad extends BaseBean{
	private Long id;
	private String title;
	private String imgFileName;
	private String link;
	private Long weight;
	
	public Ad() {
		super();
	}
	
	public Ad(Long id) {
		super();
		this.id = id;
	}

	public Ad(String title, String imgFileName, String link, Long weight) {
		super();
		this.title = title;
		this.imgFileName = imgFileName;
		this.link = link;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ad [id=" + id + ", title=" + title + "]";
	}
	
	
}
