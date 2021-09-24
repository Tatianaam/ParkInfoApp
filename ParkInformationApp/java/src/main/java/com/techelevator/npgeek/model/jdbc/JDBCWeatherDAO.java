package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDAO;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Weather mapWeatherToRowSet(SqlRowSet results, boolean bool) {
		Weather newWeather = new Weather();


		newWeather.setParkCode(results.getString("parkcode"));
		newWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		newWeather.setLow(results.getInt("low"), bool);
		newWeather.setHigh(results.getInt("high"), bool);
		newWeather.setForecast(results.getString("forecast"));
		newWeather.setAdvisory(results.getString("forecast"), results.getInt("high"), results.getInt("low"));

		
		return newWeather;

	}

	@Override
	public List<Weather> getWeatherByCode(String code, boolean bool) {
		List<Weather> weather = new ArrayList<Weather>();

		String sqlGetWeatherByParkCode = "SELECT parkcode, fivedayforecastvalue, low, high, forecast "
				+ "FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue ASC";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeatherByParkCode, code);
		
		while (results.next()) {
			weather.add(mapWeatherToRowSet(results, bool));
		}

		
		return weather;
	}

}
