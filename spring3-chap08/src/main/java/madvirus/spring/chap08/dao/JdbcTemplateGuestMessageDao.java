package madvirus.spring.chap08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import madvirus.spring.chap08.model.GuestMessage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
		int insertedCount = jdbcTemplate
				.update(
						"insert into GUESTBOOK_MESSAGE (GUEST_NAME, MESSAGE, REGISTRY_DATE) values (?, ?, ?)",
						new Object[] { message.getGuestName(),
								message.getMessage(), message.getRegistryDate() });
		if (insertedCount > 0) {
			int id = jdbcTemplate
					.queryForInt("select last_insert_id() ");
			message.setId(id);
		}
		return insertedCount;
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		return jdbcTemplate
				.query(
						"select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc limit ?, ?",
						new Object[] {begin, end},
						new RowMapper<GuestMessage>() {

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
		return jdbcTemplate
				.update(
						"update GUESTBOOK_MESSAGE set MESSAGE = ? where MESSAGE_ID = ?",
						new Object[] { message.getMessage(), message.getId() },
						new int[] { Types.VARCHAR, Types.INTEGER });
	}
}
