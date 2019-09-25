package com.packt.webstore.service.impl;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.packt.webstore.dto.NoticeDTO;
import com.packt.webstore.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Override
	public boolean saveNotice(NoticeDTO noticeDTO) {

		return true;
	}

	@Override
	public NoticeDTO getNotice(int noticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeMap<Long, NoticeDTO> getNotices(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNotice(int noticeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
