package com.ict.springboot.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cts.lms.BookApplication;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(classes = BookApplication.class, 
webEnvironment = WebEnvironment.DEFINED_PORT)
public class BookPage {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		
		//System.setProperty("webdriver.chrome.driver", "/Usr/local/bin/chromedriver");
		//driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Usr/local/bin/geckodriver");
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		
		driver.get("http://localhost:8085/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        
		driver.get("http://localhost:8085/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	@Test
	public void test1headingPresent() {
		WebElement heading1 = driver.findElement(By.id("heading1"));
		assertEquals("Library management System", heading1.getText());
		
		WebElement heading2 = driver.findElement(By.id("heading2"));
		assertEquals("Book search page", heading2.getText());
	}
	
	@Test
	public void test2BookSearchOptionType() {

		List<WebElement> bookSearch = driver.findElements(By.name("option"));
		assertNotNull(bookSearch);
		assertEquals("radio",bookSearch.get(1).getAttribute("type"));
		assertEquals(2,bookSearch.size());
	}
	@Test
	public void test3BookNamePresentsTagNameType() {

		WebElement bookName = driver.findElement(By.id("text"));
		assertNotNull(bookName);
		assertEquals("input", bookName.getTagName());
		assertEquals("text", bookName.getAttribute("type"));
	}
	
	@Test
	public void test4OptionsEmpty() { 
  
        driver.findElement(By.name("option"));
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Option not selected";
		String text = driver.findElement(By.xpath("//p[@id='error']")).getText();
		assertEquals(expectedMsg,text);
	}
	
	@Test
	public void test5TitleOrSubjectEmpty() {
		driver.findElement(By.name("option")).click();
		driver.findElement(By.id("text")).sendKeys("");
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Text field is empty";
		String text = driver.findElement(By.xpath("//p[@id='error']")).getText();
		assertEquals(expectedMsg,text);
	}
	
	@Test
	public void test6FeedbackheadingPresent() {
		driver.get("http://localhost:8085/feedback");
		WebElement heading1 = driver.findElement(By.id("heading3"));
		assertEquals("Library management System", heading1.getText());
		
		WebElement heading2 = driver.findElement(By.id("heading4"));
		assertEquals("Please provide your feedback", heading2.getText());
	}
	
	@Test
	public void test7FeedbackFormRatingType() {
		
		driver.get("http://localhost:8085/feedback");
		List<WebElement> feedback = driver.findElements(By.name("rating"));
		assertNotNull(feedback);
		assertEquals("radio",feedback.get(1).getAttribute("type"));
		assertEquals(5,feedback.size());
	}
	
	@Test
	public void test8FeedbackFormTextBoxType() {
		
		driver.get("http://localhost:8085/feedback");
		WebElement feedback = driver.findElement(By.id("fb"));
		assertNotNull(feedback);
		assertEquals("textarea", feedback.getTagName());
		
	}
	
	@Test
	public void test11FeedbackResponseBackLinkTextPresent() {
		driver.get("http://localhost:8085/feedback");
        
        driver.findElement(By.xpath("//input[@value='5']")).click();  
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("good nice book and keep it up");
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).submit();
		WebElement feedback = driver.findElement(By.id("back"));
		assertEquals("Back to search page", feedback.getText());
		
	}
	
	@Test
	public void test12subectPageBackLinkAndFeedbackLinkTextPresent() {
		driver.get("http://localhost:8085/");
		
		driver.findElement(By.xpath("//input[@value='subject']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("java");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  
		
		WebElement subject = driver.findElement(By.id("back"));
		assertEquals("Back to search page", subject.getText());
		
		WebElement subject1 = driver.findElement(By.id("fback"));
		assertEquals("Click to provide your feedback", subject1.getText());
		
	}
	
	@Test
	public void test13titlePageBackLinkAndFeedbackLinkTextPresent() {
		driver.get("http://localhost:8085/");
		
		driver.findElement(By.xpath("//input[@value='title']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("Java 8 Reference");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  
		
		WebElement subject = driver.findElement(By.id("back"));
		assertEquals("Back to search page", subject.getText());
		
		WebElement subject1 = driver.findElement(By.id("fback"));
		assertEquals("Click to provide your feedback", subject1.getText());
		
	}
	
	
	@Test
	public void test9BookControllerBySubject() {
		 
        driver.get("http://localhost:8085/");
        driver.findElement(By.xpath("//input[@value='subject']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("java");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  
        try {
        
        driver.findElement(By.linkText("Back to search page")).click();
        
        driver.findElement(By.xpath("//input[@value='subject']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("java");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  //Click to provide your feedback
        
        driver.findElement(By.linkText("Click to provide your feedback")).click();
        
        driver.findElement(By.xpath("//input[@value='5']")).click();  
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("good book and keep it up");
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).submit();
        
        driver.findElement(By.linkText("Back to search page")).click();
        
        }catch(Exception e)
        {
        	e.printStackTrace();
	}

  }
	
	@Test
	public void test10BookControllerByTitle()
	{
		  
        driver.get("http://localhost:8085/");
        driver.findElement(By.xpath("//input[@value='title']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("Java 8 Reference");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  
        try {
        
        driver.findElement(By.linkText("Back to search page")).click();
        
        driver.findElement(By.xpath("//input[@value='title']")).click();  
        
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("Java 8 Reference");
		
        driver.findElement(By.xpath("//input[@name='text']")).submit();  //Click to provide your feedback
        
        driver.findElement(By.linkText("Click to provide your feedback")).click();
        
        driver.findElement(By.xpath("//input[@value='5']")).click();  
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("good nice book and keep it up");
        
        driver.findElement(By.xpath("//textarea[@name='comment']")).submit();
        
        driver.findElement(By.linkText("Back to search page")).click();
        
        }catch(Exception e)
        {
        	e.printStackTrace();
	}
  }
}
