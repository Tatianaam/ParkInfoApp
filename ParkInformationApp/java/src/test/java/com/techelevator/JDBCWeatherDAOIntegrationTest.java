package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.jdbc.JDBCWeatherDAO;

public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCWeatherDAO weatherDAO = new JDBCWeatherDAO(getDataSource());
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	
	@Test
	public void get_Weather_returns_weather() {
		String sql = "SELECT COUNT(*) as count FROM weather WHERE parkcode = ?;";
		String code = "GNP";
		SqlRowSet select = jdbcTemplate.queryForRowSet(sql, code);
		select.next();
		long expected = select.getLong("count");
		boolean bool = true;
		List<Weather> list = weatherDAO.getWeatherByCode(code, bool);
		long result = list.size();
		Assert.assertEquals(expected, result);
	}
}
