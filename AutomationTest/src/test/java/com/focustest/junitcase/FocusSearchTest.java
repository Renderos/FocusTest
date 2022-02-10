package com.focustest.junitcase;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class FocusSearchTest {
	private WebDriver driver; 

	@Before
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");		
	}

	@Test
	public void testFocusSearch(){
		WebElement searchbox = driver.findElement(By.name("q")); //google search
		searchbox.clear();
		searchbox.sendKeys("Focus Services"); //type keywords
		searchbox.submit();		//submit search
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait 

		WebElement searchurl = driver.findElement(By.xpath("//*[contains(text(), 'https://www.focusservices.com')]"));
		searchurl.click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		WebElement NowHiring = driver.findElement(By.linkText("Now Hiring!"));
		NowHiring.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement Locations = driver.findElement(By.xpath("//*[contains(text(), 'Locations')]"));
		Locations.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jse.executeScript("window.scrollTo(0,700);");
		
		WebElement North = driver.findElement(By.xpath("//*[contains(text(), 'North America')]"));
		assertEquals(North.getText(),"NORTH AMERICA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Central = driver.findElement(By.xpath("//*[contains(text(), 'Central America')]"));
		Central.click();
		WebElement Titleh2 = driver.findElement(By.xpath("//*[contains(text(), 'El Salvador & Nicaragua')]"));
		assertEquals(Titleh2.getText(),"El Salvador & Nicaragua");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Asia = driver.findElement(By.xpath(("//*[contains(text(), 'Asia')]")));
		Asia.click();
		WebElement Bacolod = driver.findElement(By.xpath("//*[contains(text(), 'Bacolod City, Philippines')]"));
		assertEquals(Bacolod.getText(),"Bacolod City, Philippines");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
