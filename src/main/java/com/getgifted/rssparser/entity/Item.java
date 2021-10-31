package com.getgifted.rssparser.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@Column(nullable = false, unique = true)
	private String guid;
	@Column(nullable = true)
	private String title;
	@Column(nullable = true)
	private String description;
	@Column(nullable = true)
	private Timestamp publishedDate;
	@Column(nullable = true)
	@CreationTimestamp
	private Timestamp updatedDate;

	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
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
	public Timestamp getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
