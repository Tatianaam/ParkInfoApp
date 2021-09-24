package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.jdbc.JDBCParkDAO;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	private JDBCParkDAO parkDAO = new JDBCParkDAO(getDataSource());
	
	private String testID1;
	
	@Before
	public void setup() {
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, "
				   + "climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, " 
			       + "parkdescription, entryfee, numberofanimalspecies) VALUES ('FAKE', 'Fake Park', 'Pennsylvania', '100', '10', '100000', " 
				   + "'5', 'Temperate', '2019', '20', 'Wow much inspiration', 'Fake Person', 'Its a park allright', '0', '50') RETURNING parkcode";
		
		testID1 = jdbcTemplate.queryForObject(sql, String.class);
				
	}
	
	@Test
	public void get_Park_returns_all_parks() {
		String sql = "SELECT COUNT(*) as park_count FROM park";
		SqlRowSet select = jdbcTemplate.queryForRowSet(sql);
		select.next();
		long expected = select.getLong("park_count");
		long result = (long)parkDAO.getAllParks().size();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void get_Park_by_park_code() {
		Park test = parkDAO.getParkByCode(testID1);
		
		Assert.assertEquals("FAKE", test.getParkCode());
		Assert.assertEquals("Fake Park", test.getName());
		Assert.assertEquals("Pennsylvania", test.getState());
	}

}
