package madvirus.spring.chap08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import madvirus.spring.chap08.model.GuestMessage;

public class JdbcTemplateGuestMessageDao implements GuestMessageDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateGuestMessageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int count() {
		return jdbcTemplate
				.queryForInt("select count(*) from GUESTBOOK_MESSAGE");
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update(
				"delete from GUESTBOOK_MESSAGE where MESSAGE_ID = ?", id);
	}

	@Override
	public int insert(GuestMessage message) {
		return jdbcTemplate
				.update(
						"insert into GUESTBOOK_MESSAGE (GUEST_NAME, MESSAGE) values (?, ?, ?)",
						message.getGuestName(), message.getMessage(), message
								.getRegistryDate());
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		return jdbcTemplate.query("select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc limit ?, ?", new RowMapper<GuestMessage> () {

			@Override
			public GuestMessage mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				GuestMessage message = new GuestMessage();
				return null;
			}
		});
	}

	@Override
	public int update(GuestMessage message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
