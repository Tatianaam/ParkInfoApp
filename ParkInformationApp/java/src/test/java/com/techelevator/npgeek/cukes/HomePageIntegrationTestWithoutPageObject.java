package com.techelevator.npgeek.cukes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageIntegrationTestWithoutPageObject extends Hooks{

	@Test
	public void elements_can_be_found_by_id() throws InterruptedException {
		WebElement parkName = webDriver.findElement(By.id("parkName"));
		
		Assert.assertNotNull(parkName);
		assertEquals("Cuyahoga Valley National Park, Ohio", parkName.getText());
	}

	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver.findElement(By.tagName("header"));
		WebElement footer = webDriver.findElement(By.tagName("footer"));
		assertNotNull(header);
		assertNotNull(footer);
	}

	@Test
	public void pages_can_be_navigated_by_clicking_on_links() {	
		WebElement surveyLink = webDriver.findElement(By.id("surveyLink"));
		surveyLink.click();
		assertTrue(webDriver.getTitle().endsWith("App"));
		
		WebElement h1 = webDriver.findElement(By.id("question"));
		assertEquals("Whats your favorite park?", h1.getText());
	}


}
