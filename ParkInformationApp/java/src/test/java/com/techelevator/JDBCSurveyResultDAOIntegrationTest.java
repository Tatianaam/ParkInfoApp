package com.techelevator;



import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.SurveyResult;
import com.techelevator.npgeek.model.jdbc.JDBCSurveyResultDAO;



public class JDBCSurveyResultDAOIntegrationTest extends DAOIntegrationTest {

	private JDBCSurveyResultDAO dao = new JDBCSurveyResultDAO(getDataSource());
	JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

	private long testId1;
	private long testId2;
	private long testId3;
	private long testId4;
	private long testId5;
	private long testId6;

	@Before
	public void setup() {

		String sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES ('test1', 'a@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId1 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES ('test2', 'a2@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId2 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES ('test2', 'a22@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId3 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES ('test3', 'a3@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId4 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES ('test3', 'a33@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId5 = jdbcTemplate.queryForObject(sql, Long.TYPE);

		sql = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)"
				+ "VALUES ('test3', 'a333@a.com', 'TE', 'superactive') RETURNING surveyid";

		testId6 = jdbcTemplate.queryForObject(sql, Long.TYPE);

	}

	@Test
	public void testGetSurveyById() {

		SurveyResult test = dao.getResultByResultID(testId1);

		Assert.assertNotNull(test);
		Assert.assertEquals(testId1, test.getSurveyId());

	}

	@Test
	public void testWritingtoDataBase() {

		SurveyResult test = new SurveyResult();
		test.setActivityLevel("test");
		test.setEmail("test@Test.com");
		test.setParkCode("TEST");
		test.setState("TE");

		long testID = dao.addSurveyResultToDatabase(test);

		test.setSurveyId(testID);

		Assert.assertNotNull(dao.getResultByResultID(testID));

		Assert.assertEquals("test", dao.getResultByResultID(testID).getActivityLevel());

	}

	@Test
	public void testGetCodesAndVotes() {
		
		Map<String, Integer> testMap = dao.getCodesAndVotes();
		
		Assert.assertNotNull(testMap);
		
		int actual1 = testMap.get("test1");
		int actual2 = testMap.get("test2");
		int actual3 = testMap.get("test3");
		
		Assert.assertEquals(1, actual1);
		Assert.assertEquals(2, actual2);
		Assert.assertEquals(3, actual3);

	}

}
