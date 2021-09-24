package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkDAO {

	List<Park> getAllParks();

	public Park getParkByCode(String code);
}
