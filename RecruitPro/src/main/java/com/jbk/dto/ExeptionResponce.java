package com.jbk.dto;

import java.sql.Timestamp;

public class ExeptionResponce {

	private String path;

	public ExeptionResponce(String path, String username, Timestamp timestamp) {
		super();
		this.path = path;
		this.username = username;
		this.timestamp = timestamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	private String username;
	private Timestamp timestamp;
	public ExeptionResponce() {
		// TODO Auto-generated constructor stub
	}
	}