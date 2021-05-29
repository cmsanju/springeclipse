package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class CollegeApplicationPage 
{
	WebDriver driver;
	@Before
	public void launchBrowser() {
		
		/*
		System.setProperty("webdriver.gecko.driver", "/Usr/local/bin/geckodriver");
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);

		driver.get("http://localhost:8080/ABCCollegeAppplication/CollegeApplication.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.gecko.driver","/Usr/local/bin/geckodriver");

		WebDriver driver=new FirefoxDriver();
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
	    capabilities.setCapability("marionette",true);  
	    WebDriver driver= new FirefoxDriver(capabilities);
		driver.get("http://localhost:8080/ABCCollegeAppplication/CollegeApplication.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
		 //declaration and instantiation of objects/variables 
		
		//https://chromedriver.storage.googleapis.com/index.html?path=90.0.4430.24/
		//https://chromedriver.chromium.org/downloads
		
		System.setProperty("webdriver.chrome.driver", "/Usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		
		// Launch Website  
        driver.navigate().to("http://localhost:8080/ABCCollegeAppplication/CollegeApplication.html");  
          
         //Maximize the browser  
          driver.manage().window().maximize();  
		
	}

	@After
	public void teardown() {
		driver.close();
	}
	@Test
	public void test1headingsPresent() {
		
		WebElement heading1 = driver.findElement(By.id("heading1"));
		assertEquals("ABC College Online Application Form-11th Grade", heading1.getText());
		
		
	} 
	
	@Test
	public void test2collegeApplicationPageFieldsType() {
		
		
		WebElement aaid = driver.findElement(By.id("aadhaarCardNo"));
		assertNotNull(aaid);
		assertEquals("input", aaid.getTagName());
		
		WebElement cname = driver.findElement(By.id("cname"));
		assertNotNull(cname);
		assertEquals("input", cname.getTagName());
		
		WebElement gender = driver.findElement(By.id("male"));
		assertNotNull(gender);
		assertEquals("input", gender.getTagName());
		
		WebElement gender1 = driver.findElement(By.id("female"));
		assertNotNull(gender1);
		assertEquals("input", gender1.getTagName());
		
		WebElement addr = driver.findElement(By.id("address"));
		assertNotNull(addr);
		assertEquals("textarea", addr.getTagName());
		
		WebElement mobile = driver.findElement(By.id("mobileNumber"));
		assertNotNull(mobile);
		assertEquals("input", mobile.getTagName());
		
		WebElement email = driver.findElement(By.id("email"));
		assertNotNull(email);
		assertEquals("input", email.getTagName());
		
		WebElement bdate = driver.findElement(By.id("bdate"));
		assertNotNull(bdate);
		assertEquals("input", bdate.getTagName());
		
		WebElement strm = driver.findElement(By.id("viewByStream"));
		assertNotNull(strm);
		assertEquals("select", strm.getTagName());
		
		WebElement scr = driver.findElement(By.id("score"));
		assertNotNull(scr);
		assertEquals("input", scr.getTagName());
		
		WebElement sbt = driver.findElement(By.id("submit"));
		assertNotNull(sbt);
		assertEquals("input", sbt.getTagName());
		
		WebElement rst = driver.findElement(By.id("reset"));
		assertNotNull(rst);
		assertEquals("input", rst.getTagName());
		
	}
	
	@Test
	public void test3submitStudentDeatails() { 
        driver.findElement(By.id("aadhaarCardNo")).sendKeys("540237999001");
        driver.findElement(By.id("cname")).sendKeys("Rock");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("female")).click();
        driver.findElement(By.id("address")).sendKeys("bangalore");
        driver.findElement(By.id("mobileNumber")).sendKeys("9898989898");
        driver.findElement(By.id("email")).sendKeys("java@gmail.com");
        driver.findElement(By.id("bdate")).sendKeys("25/09/2003");
        WebElement locn = driver.findElement(By.id("viewByStream"));
        Select drb = new Select(locn);
        driver.findElement(By.id("score")).sendKeys("75");
        
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("reset")).click();  
	}
	
	@Test
	public void test4submitStudentDeatailsFail() { 
		driver.findElement(By.id("aadhaarCardNo")).sendKeys("27999001");
        driver.findElement(By.id("cname")).sendKeys("Rock");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("female")).click();
        driver.findElement(By.id("address")).sendKeys("bangalore");
        driver.findElement(By.id("mobileNumber")).sendKeys("9898989898");
        driver.findElement(By.id("email")).sendKeys("java@gmail.com");
        driver.findElement(By.id("bdate")).sendKeys("25/09/2003");
        WebElement locn = driver.findElement(By.id("viewByStream"));
        Select drb = new Select(locn);
        driver.findElement(By.id("score")).sendKeys("75");
        
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("reset")).click();   
	} 
	
	@Test
	public void test5FormTagPresent() {
		WebElement form = driver.findElement(By.tagName("form"));
		assertNotNull(form);
		assertEquals("return applnRegistration()", driver.findElement(By.tagName("form")).getAttribute("onsubmit"));
		
	}
	
	@Test
	public void test6submitStudentDeatailsJS() {
		driver.findElement(By.id("aadhaarCardNo")).sendKeys("540237999001");
        driver.findElement(By.id("cname")).sendKeys("Rock");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("female")).click();
        driver.findElement(By.id("address")).sendKeys("bangalore");
        driver.findElement(By.id("mobileNumber")).sendKeys("9898989898");
        driver.findElement(By.id("email")).sendKeys("java@gmail.com");
        driver.findElement(By.id("bdate")).sendKeys("25/09/2003");
        WebElement locn = driver.findElement(By.id("viewByStream"));
        Select drb = new Select(locn);
        driver.findElement(By.id("score")).sendKeys("75");
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById('cname').value='Rock'");
		
		js.executeScript("document.getElementById('email').value='java@gmail.com'");
		
		js.executeScript("document.getElementById('score').value='95'");
		
	
		js.executeScript("applnRegistration()");	
			
		
		assertEquals("Dear Rock,\n" + 
				"You are have Eligible for Science Stream !!\n" + 
				"The payment details will be mailed on java@gmail.com",driver.findElement(By.id("result")).getText());
	}
	
}
