package com.packt.webstore.service.impl;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Notice;
import com.packt.webstore.domain.repository.NoticeRepository;
import com.packt.webstore.dto.NoticeDTO;
import com.packt.webstore.service.EmailService;
import com.packt.webstore.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	EmailService emailService;

	@Override
	public boolean saveNotice(NoticeDTO noticeDTO) {
		// save the notice to db
		Notice notice = new Notice();
		notice.setNoticeId(1001);
		notice.setPublisherId(noticeDTO.getPublisherId());
		notice.setPublishTime(System.currentTimeMillis());
		notice.setReceiver(noticeDTO.getToId());
		notice.setSubject(noticeDTO.getSubject());
		notice.setDescription(noticeDTO.getDescription());
		System.out.println(notice);
		noticeRepository.saveNotice(notice);

		// get who will get mail notifications

		// email the notice to corresponding users
		emailService.sendMail(noticeDTO.getFrom(), noticeDTO.getMailPassword(), "academicstudy0001cplus@gmail.com",
				noticeDTO.getSubject(), noticeDTO.getDescription());

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

	@Override
	public TreeMap<Long, NoticeDTO> getNotices(int publisherId) {

		List<Notice> notices = noticeRepository.getNotices(publisherId);
		TreeMap<Long, NoticeDTO> noticeDTOs = new TreeMap<>();

		for (Notice m : notices) {
			NoticeDTO dto = new NoticeDTO();
			dto.setPublisherId(publisherId);
			dto.setNoticeId(m.getNoticeId());
			dto.setSubject(m.getSubject());
			dto.setToId(m.getReceiver());
			dto.setDescription(m.getDescription());
			noticeDTOs.put(m.getPublish_time(), dto);
		}

		return noticeDTOs;
	}

}
