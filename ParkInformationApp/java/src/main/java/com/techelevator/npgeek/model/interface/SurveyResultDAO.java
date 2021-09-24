package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

import com.techelevator.npgeek.model.SurveyResult;

public interface SurveyResultDAO {
	
	public SurveyResult getResultByResultID(Long id);
	
	public long addSurveyResultToDatabase(SurveyResult survey);
	
	/***
	 * 
	 * @return Map with Park Codes(Key) and number of votes(Value) for the park.
	 * 	    
	 */
	public Map<String, Integer> getCodesAndVotes();
	

}
