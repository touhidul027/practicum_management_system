package com.packt.webstore.domain;

public class Notice {
	private int noticeId;
	private int publisherId;
	private long publishTime;
	private String receiver;
	private String subject;
	private String description;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNoticeId() {
		return noticeId;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", publisherId=" + publisherId + ", publish_time=" + publishTime
				+ ", receiver=" + receiver + ", subject=" + subject + ", description=" + description + "]";
	}

	public Notice(int noticeId, int publisherId, long publishTime, String receiver, String subject,
			String description) {
		super();
		this.noticeId = noticeId;
		this.publisherId = publisherId;
		this.publishTime = publishTime;
		this.receiver = receiver;
		this.subject = subject;
		this.description = description;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public long getPublish_time() {
		return publishTime;
	}

	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
