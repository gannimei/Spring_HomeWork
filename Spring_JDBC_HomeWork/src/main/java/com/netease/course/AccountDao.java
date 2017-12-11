package com.netease.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Account> getAccountList() {
		return this.jdbcTemplate.query("select * from UserBalance", new RowMapper<Account>() {

			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setUserId(rs.getLong("userId"));
				account.setBalance(rs.getDouble("balance"));
				return account;
			}

		});
	}

	@Transactional
	public void transferMoney(long srcUserId, long targetUserId, double count) {
		this.jdbcTemplate.update("update UserBalance set balance=balance-? where userId=?", count, srcUserId);
		this.jdbcTemplate.update("update UserBalance set balance=balance+? where userId=?", count, targetUserId);
	}

	public void resetBalance() {
		this.jdbcTemplate.update("update UserBalance set balance=1000");
	}

}
