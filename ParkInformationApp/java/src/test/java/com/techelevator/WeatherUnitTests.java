package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.Weather;



public class WeatherUnitTests {
	
	Weather weather;
	
	@Before
	public void setup() {
		this.weather = new Weather();
		 weather.setHigh(58, true);
		 weather.setLow(30, true);
		 weather.setAdvisory("snow", 32, 20);
		 
	}
	
	@Test
	public void weather_getHigh_converts_properly() {
		Assert.assertEquals("58°F", weather.getHigh());
		weather.setHigh(68, false);
		Assert.assertEquals("20°C", weather.getHigh());
	}
	
	@Test
	public void weather_getLow_converts_properly() {
		Assert.assertEquals("30°F", weather.getLow());
		weather.setLow(32, false);
		Assert.assertEquals("0°C", weather.getLow());
	}
	
	@Test
	public void weather_getAdvisory_works() {	
		List<String> newWeather = weather.getAdvisory();
		Assert.assertEquals("Pack Snowshoes", newWeather.get(0));
		weather.setAdvisory("rain", 78, 50);
		newWeather = weather.getAdvisory();
		Assert.assertEquals("Pack Rain Gear and Waterproof Shoes", newWeather.get(0));
	}

}
