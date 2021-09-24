package com.techelevator.npgeek.cukes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;

public abstract class Hooks {

	protected static WebDriver webDriver;
	
	@Before
	public void setup() {
		webDriver.manage().deleteAllCookies();
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}


	@BeforeClass
	public static void openWebBrowserForTesting() {

		String homeDir = System.getProperty("user.home"); 
		System.setProperty("webdriver.chrome.driver", homeDir + "/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@AfterClass
	public static void closeWebBrowser() {
		webDriver.quit();
	}
	
}
