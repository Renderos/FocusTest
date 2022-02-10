package com.focustest.junitcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
	public void test() {
		fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
