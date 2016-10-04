package com.response;

public class Response {

	String status;
	String comment;
	public Response(String status, String comment) {
		super();
		this.status = status;
		this.comment = comment;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
