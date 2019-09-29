package com.packt.webstore.dto;

public class NoticeDTO {
	private int noticeId;
	private String subject;
	private String description;
	private String from;
	private String toId;
	private int publisherId;
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public NoticeDTO(String subject, String description) {
		super();
		this.subject = subject;
		this.description = description;
	}
	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeId=" + noticeId + ", subject=" + subject + ", description=" + description + ", from="
				+ from + ", toId=" + toId + "]";
	}
	
	
}
