package madvirus.spring.chap16.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import madvirus.spring.chap16.model.GuestMessage;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleJdbcGuestMessageDao implements GuestMessageDao {

	private SimpleJdbcTemplate template;
	private SimpleJdbcInsert insertMessage;

	public SimpleJdbcGuestMessageDao(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
		insertMessage = new SimpleJdbcInsert(dataSource);
		insertMessage.withTableName("GUESTBOOK_MESSAGE")
				.usingGeneratedKeyColumns("MESSAGE_ID")
				.usingColumns("GUEST_NAME", "MESSAGE", "REGISTRY_DATE");
	}

	@Override
	public int count() {
		return template.queryForInt("select count(*) from GUESTBOOK_MESSAGE");
	}

	@Override
	public int delete(int id) {
		return template.update(
				"delete from GUESTBOOK_MESSAGE where MESSAGE_ID = ?", id);
	}

	@Override
	public int insert(GuestMessage message) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				message);
		Number keyValue = insertMessage.executeAndReturnKey(paramSource);
		message.setId(keyValue.intValue());
		return 1;
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		int startRowNum = begin - 1;
		int count = end - begin + 1;
		return template
				.query(
						"select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc limit ?, ?",
						new GuestMessageRowMapper(), startRowNum, count);
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
