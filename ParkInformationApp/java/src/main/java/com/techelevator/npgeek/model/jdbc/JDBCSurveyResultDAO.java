package com.techelevator.npgeek.model.jdbc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.sql.RowSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.SurveyResult;
import com.techelevator.npgeek.model.SurveyResultDAO;

@Component
public class JDBCSurveyResultDAO implements SurveyResultDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyResultDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SurveyResult getResultByResultID(Long id) {
		SurveyResult result = new SurveyResult();

		String sql = "SELECT surveyid, parkcode, emailaddress, state, "
				+ "activitylevel FROM survey_result WHERE surveyid = ?";

		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);

		if (rowSet.next()) {
			result = mapRowToSurveyResult(rowSet);
		}

		return result;
	}

	@Override
	public Map<String, Integer> getCodesAndVotes() {
		
		Map<String, Integer> result = new LinkedHashMap<String, Integer>(); 
		
		String sql = "SELECT survey_result.parkcode, count(surveyid) AS number FROM survey_result " + 
				"LEFT JOIN park ON survey_result.parkcode = park.parkcode " + 
				"GROUP BY survey_result.parkcode, park.parkname ORDER BY number DESC, park.parkname ASC";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		
		while (rowSet.next()) {
			result.put(rowSet.getString("parkcode"), rowSet.getInt("number"));
		}
				
		return result;
	}

	@Override
	public long addSurveyResultToDatabase(SurveyResult survey) {

		String sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES (?, ?, ?, ?) RETURNING surveyid";

		long result = jdbcTemplate.queryForObject(sql, Long.TYPE, survey.getParkCode(), survey.getEmail(), survey.getState(),
				survey.getActivityLevel());
		
		return result;

	}

	private SurveyResult mapRowToSurveyResult(SqlRowSet rowSet) {
		SurveyResult result = new SurveyResult();

		result.setActivityLevel(rowSet.getString("activitylevel"));
		result.setState(rowSet.getString("state"));
		result.setEmail(rowSet.getString("emailaddress"));
		result.setParkCode(rowSet.getString("parkcode"));
		result.setSurveyId(rowSet.getLong("surveyid"));

		return result;
	}

}
