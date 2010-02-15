package madvirus.spring.chap08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import madvirus.spring.chap08.model.GuestMessage;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class NamedParamGuestMessageDao implements GuestMessageDao {

	private NamedParameterJdbcTemplate template;

	public NamedParamGuestMessageDao(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int count() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return template.queryForInt("select count(*) from GUESTBOOK_MESSAGE",
				paramMap);
	}

	@Override
	public int delete(int id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return template.update(
				"delete from GUESTBOOK_MESSAGE where MESSAGE_ID = :id",
				paramMap);
	}

	@Override
	public int insert(GuestMessage message) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				message);
		int insertedCount = template.update(
				"insert into GUESTBOOK_MESSAGE (GUEST_NAME, MESSAGE, REGISTRY_DATE) values "
						+ "(:guestName, :message, :registryDate)", paramSource);
		if (insertedCount > 0) {
			int id = template.queryForInt("select last_insert_id() ",
					Collections.<String, Object> emptyMap());
			message.setId(id);
		}
		return insertedCount;
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", begin - 1);
		paramMap.put("count", end - begin + 1);
		return template
				.query(
						"select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc limit :startRowNum, :count",
						paramMap, new RowMapper<GuestMessage>() {

							@Override
							public GuestMessage mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								GuestMessage message = new GuestMessage();
								message.setId(rs.getInt("MESSAGE_ID"));
								message
										.setGuestName(rs
												.getString("GUEST_NAME"));
								message.setMessage(rs.getString("MESSAGE"));
								message.setRegistryDate(rs
										.getDate("REGISTRY_DATE"));
								return message;
							}

						});
	}

	@Override
	public int update(GuestMessage message) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("id", message.getId(), Types.INTEGER);
		return template
				.update(
						"update GUESTBOOK_MESSAGE set MESSAGE = :message where MESSAGE_ID = :id",
						paramSource);
	}

}
