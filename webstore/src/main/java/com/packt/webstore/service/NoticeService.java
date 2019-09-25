package com.packt.webstore.service;

import java.util.TreeMap;

import com.packt.webstore.dto.NoticeDTO;

public interface NoticeService {

public abstract	boolean saveNotice(NoticeDTO noticeDTO);
public abstract NoticeDTO getNotice(int noticeId);
public abstract TreeMap<Long,NoticeDTO> getNotices(String userEmail);
public abstract boolean deleteNotice(int noticeId);

}
