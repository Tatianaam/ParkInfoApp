package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Park mapParkToRowSet(SqlRowSet results) {
		String parkCodeLowerCase = results.getString("parkcode").toLowerCase();

		Park newPark = new Park();

		newPark.setParkCode(results.getString("parkcode"));
		newPark.setName(results.getString("parkname"));
		newPark.setState(results.getString("state"));
		newPark.setAcreage(results.getInt("acreage"));
		newPark.setElevationInFeet(results.getInt("elevationinfeet"));
		newPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		newPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		newPark.setClimate(results.getString("climate"));
		newPark.setYearFounded(results.getInt("yearfounded"));
		newPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		newPark.setInspirationalQuote(results.getString("inspirationalquote"));
		newPark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		newPark.setParkDescription(results.getString("parkdescription"));
		newPark.setEntryFee(results.getInt("entryfee"));
		newPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		newPark.setParkImgCode(parkCodeLowerCase);

		return newPark;

	}

	@Override
	public List<Park> getAllParks() {

		ArrayList<Park> getAllParks = new ArrayList<>();

		String sqlGetAllParks = "SELECT * FROM park ORDER BY parkname";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);

		while (results.next()) {
			Park newPark = mapParkToRowSet(results);
			getAllParks.add(newPark);
		}
		return getAllParks;
	}

	@Override
	public Park getParkByCode(String code) {
		String sqlGetParkByCode = "SELECT * FROM park WHERE parkcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByCode, code);

		if (results.next()) {
			return mapParkToRowSet(results);
		}
		return null;
	}

}
