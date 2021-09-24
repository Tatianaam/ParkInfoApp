START TRANSACTION;

SELECT * FROM survey_result;

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test1', 'a@a.com', 'TE', 'superactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test2', 'a2@a.com', 'TE', 'superactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test2', 'a22@a.com', 'TE', 'superactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test3', 'a3@a.com', 'TE', 'superactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test3', 'a33@a.com', 'TE', 'superactive');

INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel)
VALUES ('test3', 'a333@a.com', 'TE', 'superactive');

SELECT * FROM survey_result;

SELECT survey_result.parkcode, park.parkname, count(surveyid) AS number FROM survey_result
JOIN park ON survey_result.parkcode = park.parkcode
GROUP BY survey_result.parkcode, park.parkname ORDER BY number DESC, park.parkname ASC;

SELECT surveyid, parkcode, emailaddress, state, activitylevel FROM survey_result WHERE surveyid = 34;

ROLLBACK;

SELECT * FROM park;

SELECT parkcode, fivedayforecastvalue, low, high, forecast FROM weather WHERE parkcode = 'ENP' ORDER BY fivedayforecastvalue ASC;