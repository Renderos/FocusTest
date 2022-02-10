package com.focustest.junitcase;



import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FocusSearchTest {
	private WebDriver driver; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");		
	}

	@Test
	public void testFocusSearch() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Focus Services");
		searchbox.submit();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement searchurl = driver.findElement(By.xpath("//*[contains(text(), 'https://www.focusservices.com')]"));
			searchurl.click();

	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
