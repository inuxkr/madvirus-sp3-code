package madvirus.spring.chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import madvirus.spring.chap08.model.GuestMessage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
	public int insert(final GuestMessage message) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int insertedCount = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con
						.prepareStatement(
								"insert into GUESTBOOK_MESSAGE (GUEST_NAME, MESSAGE, REGISTRY_DATE) values (?, ?, ?)",
								new String[] { "MESSAGE_ID" });
				pstmt.setString(1, message.getGuestName());
				pstmt.setString(2, message.getMessage());
				pstmt.setTimestamp(3, new Timestamp(message.getRegistryDate()
						.getTime()));
				return pstmt;
			}
		}, keyHolder);
		Number keyNumber = keyHolder.getKey();
		message.setId(keyNumber.intValue());
		return insertedCount;
		// int insertedCount = jdbcTemplate
		// .update(
		// "insert into GUESTBOOK_MESSAGE (GUEST_NAME, MESSAGE, REGISTRY_DATE) values (?, ?, ?)",
		// message.getGuestName(), message.getMessage(), message
		// .getRegistryDate());
		// if (insertedCount > 0) {
		// int id = jdbcTemplate.queryForInt("select last_insert_id() ");
		// message.setId(id);
		// }
		// return insertedCount;
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		int startRowNum = begin - 1;
		int count = end - begin + 1;
		return jdbcTemplate
				.query(
						"select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc limit ?, ?",
						new Object[] { startRowNum, count },
						new GuestMessageRowMapper());
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
