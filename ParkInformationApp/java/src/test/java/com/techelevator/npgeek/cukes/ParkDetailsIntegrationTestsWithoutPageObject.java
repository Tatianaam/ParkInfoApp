package com.techelevator.npgeek.cukes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ParkDetailsIntegrationTestsWithoutPageObject extends Hooks {

	@Test
	public void product_with_img_name_price_is_present() {
		
		WebElement homeParkImgLink = webDriver.findElement(By.id("homeParkImgLink"));
		homeParkImgLink.click();
		WebElement img = webDriver.findElement(By.id("detailSParkImg"));
		WebElement name = webDriver.findElement(By.id("detailsParkName"));
		WebElement quote = webDriver.findElement(By.id("inspQuote"));
		assertNotNull("checks the presence of img", img);
		assertNotNull("checks the presence of name", name);
		assertNotNull("checks the presence of quote", quote);

	}

	@Test
	public void navigate_to_product_details_check_that_product_is_correct() {
		
		String nameList = webDriver.findElement(By.id("parkName")).getText().substring(0, 5);
		WebElement homeParkImgLink = webDriver.findElement(By.id("homeParkImgLink"));
		homeParkImgLink.click();
		assertNotNull(webDriver.findElement(By.tagName("h1")));
		WebElement nameDetails = webDriver.findElement(By.id("detailsParkName"));
		assertTrue("Checks that the name of product is same", nameDetails.getText().startsWith(nameList));
	}
}
