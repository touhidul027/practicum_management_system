package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Notice;

public interface NoticeRepository {
	public abstract boolean saveNotice(Notice notice);
	public abstract List<Notice> getNotices(int publisherId);
}
