package com.focustest.junitcase;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			
			
			

	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

}
