package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Notice;
import com.packt.webstore.domain.repository.NoticeRepository;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public boolean saveNotice(Notice notice) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("noticeId", notice.getNoticeId());
		paramMaps.put("publisherId", notice.getPublisherId());
		paramMaps.put("publishTime", notice.getPublish_time());
		paramMaps.put("receiver", notice.getReceiver());
		paramMaps.put("subject", notice.getSubject());
		paramMaps.put("description", notice.getDescription());

		String sql = "INSERT INTO notices(notice_id ,publisher_id,receiver_string,publish_time,subject,description )"
				+ " VALUES(:noticeId,:publisherId,:receiver,:publishTime,:subject,:description)";

		int affectedRow = jdbcTemplate.update(sql, paramMaps);
		System.out.println(notice);
		return affectedRow != 0 ? true : false;
	}
	
	@Override
	public List<Notice> getNotices(int publisherId) {
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("publisherId", publisherId);
		List<Notice> notices = jdbcTemplate.query("SELECT * FROM notices WHERE publisher_id=:publisherId", paramMaps,
				new NoticeMapper());

		return notices;
	}

	private static final class NoticeMapper implements RowMapper<Notice> {
		@Override
		public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
			Notice notice = new Notice();
			notice.setPublisherId(rs.getInt("publisher_id"));
			notice.setPublishTime(rs.getLong("publish_time"));
			notice.setSubject(rs.getString("subject"));
			notice.setDescription(rs.getString("description"));
			notice.setReceiver(rs.getString("receiver_string"));
			return notice;
		}
	}	
}
