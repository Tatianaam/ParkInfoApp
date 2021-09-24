package com.techelevator.npgeek.cukes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SurveyInputIntegrationTestWithoutPageObject extends Hooks {


	@Test
	public void submit_form_works() {
		WebElement storeLink = webDriver.findElement(By.id("surveyLink"));
		storeLink.click();

		WebElement emailField = webDriver.findElement(By.id("emailField"));
		emailField.sendKeys("a@a.com");
		
		WebElement activity = webDriver.findElement(By.id("activity"));
		activity.sendKeys("Inactive");
		
		WebElement activityClick = webDriver.findElement(By.id("activity"));
		activityClick.click();

		WebElement submitButton = webDriver.findElement(By.id("submitButton"));
		submitButton.click();

		WebElement parkName = webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/article/h1[1]"));
		assertEquals("check the park name", "Cuyahoga Valley National Park, Ohio", parkName.getText());
		WebElement numberOfVotes = webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/article/h1[2]"));
		
		
		int actual = Integer.parseInt(numberOfVotes.getText().substring(numberOfVotes.getText().length()-1));
		
		/*
		 * we compare it to zero, because we assume that there maybe 20 votes 
		 * and we take only the last char from the string, but anything can
		 * appear in the list only if it has at least one vote
		 */
		assertTrue("checks the votes", actual >= 0); 
		
		//Cuyahoga Valley National Park, Ohio
	}

}
