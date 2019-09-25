package com.packt.webstore.domain;

public class Notice {
	private int noticeId;
	private String subject;
	private String description;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int noticeId, String subject, String description) {
		super();
		this.noticeId = noticeId;
		this.subject = subject;
		this.description = description;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", subject=" + subject + ", description=" + description + "]";
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

}
