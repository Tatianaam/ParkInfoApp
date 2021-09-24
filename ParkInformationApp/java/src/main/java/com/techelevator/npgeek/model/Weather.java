package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private String low;
	private String high;
	private String forecast;
	private String forecastImg;
	private List<String> advisory;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public String getLow() {
		return low;
	}

	public void setLow(int low, boolean bool) {
		if (bool) {
			this.low = low + "°F";
		} else {
			this.low = ((int) ((low - 32) / 1.8)) + "°C";
		}
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(int high, boolean bool) {
		if (bool) {
			this.high = high + "°F";
		} else {
			this.high = ((int) ((high - 32) / 1.8)) + "°C";
		}
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getForecastImg() {
		return forecastImg;
	}

	public void setForecastImg(String forecastImg) {
		this.forecastImg = forecastImg;
	}

	public List<String> getAdvisory() {
		return advisory;
	}

	public void setAdvisory(String forecast, int high, int low) {
		advisory = new ArrayList<String>();

		if (forecast.equals("snow")) {
			this.advisory.add("Pack Snowshoes");
			this.forecastImg = "snow.png";

		} else if (forecast.equals("cloudy")) {
			this.forecastImg = "cloudy.png";

		} else if (forecast.equals("partly cloudy")) {
			this.forecastImg = "partlyCloudy.png";

		} else if (forecast.equals("rain")) {
			this.advisory.add("Pack Rain Gear and Waterproof Shoes");
			this.forecastImg = "rain.png";

		} else if (forecast.equals("sunny")) {
			this.advisory.add("Pack Sunblock");
			this.forecastImg = "sunny.png";

		} else if (forecast.equals("thunderstorms")) {
			this.advisory.add("Seek Shelter and Avoid Hiking on Exposed Ridges");
			this.forecastImg = "thunderstorms.png";
		}
		
		if (high > 75 || low > 75) {
			this.advisory.add("Bring an extra gallon of water");
		}
		if (high - low > 20) {
			this.advisory.add("Wear breathable layers");
		}
		if (high < 20 || low < 20) {
			this.advisory.add("Be wary of frostbite");
		}

	}

}
