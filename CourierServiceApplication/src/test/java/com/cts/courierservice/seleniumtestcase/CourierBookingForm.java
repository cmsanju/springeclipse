package com.cts.courierservice.seleniumtestcase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CourierBookingForm {

	static WebDriver driver;

	static String appPath = "http://localhost:7070/showCourierBookingForm";
	static String appPathWithPort = "http://localhost:7070/";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);

		driver.get(appPath);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	@Test(priority = 1)
	public void testheadingPresent() {
		WebElement heading = driver.findElement(By.id("heading"));
		assertEquals("Appex Courier Services", heading.getText());
	}

	@Test(priority = 2)
	public void testcustomerNamePresentsTagNameType() {
		WebElement customerName = driver.findElement(By.id("customerName"));
		assertNotNull(customerName);
		assertEquals("input", customerName.getTagName());
		assertEquals("text", customerName.getAttribute("type"));
	}

	@Test(priority = 3)
	public void testcustomerCityPresentsTagNameType() {
		WebElement customerCity = driver.findElement(By.id("customerCity"));
		assertNotNull(customerCity);
		assertEquals("select", customerCity.getTagName());
	}

	@Test(priority = 4)
	public void testmobileNumberPresentsTagNameType() {
		WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
		assertNotNull(mobileNumber);
		assertEquals("input", mobileNumber.getTagName());
		assertEquals("text", mobileNumber.getAttribute("type"));
	}

	@Test(priority = 5)
	public void testcourierDeliveryAreaPresentsTagNameType() {

		List<WebElement> courierDeliveryArea = driver.findElements(By.name("courierDeliveryArea"));
		assertNotNull(courierDeliveryArea);
		assertEquals("radio", courierDeliveryArea.get(1).getAttribute("type"));
		assertEquals(2, courierDeliveryArea.size());
	}

	@Test(priority = 6)
	public void testpacketWeightInGramsPresentsTagNameType() {
		WebElement packetWeightInGrams = driver.findElement(By.id("packetWeightInGrams"));
		assertNotNull(packetWeightInGrams);
		assertEquals("input", packetWeightInGrams.getTagName());
		assertEquals("text", packetWeightInGrams.getAttribute("type"));
	}

	@Test(priority = 7)
	public void testsubmitPresentsTagNameType() {

		WebElement PayableAmount = driver.findElement(By.name("submit"));
		assertNotNull(PayableAmount);
		assertEquals("input", PayableAmount.getTagName());
		assertEquals("submit", PayableAmount.getAttribute("type"));
		assertEquals("PayableAmount", PayableAmount.getAttribute("value"));
	}

	@Test(priority = 8)
	public void testFormPresentActionValueMethodName() {
		WebElement myform = driver.findElement(By.name("form"));
		assertNotNull(myform);
		assertEquals(appPathWithPort + "getCourierDeliveryCharges", myform.getAttribute("action"));
		assertEquals("post", myform.getAttribute("method"));
	}

	@Test(priority = 9)
	public void testcustomerNameEmpty() {

		driver.findElement(By.id("customerName")).sendKeys("");
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Customer name is required";
		String text = driver.findElement(By.xpath("//*[@id=\'customerName.errors\']")).getText();
		assertEquals(expectedMsg, text);
	}

	@Test(priority = 10)
	public void testmobileNumberWrong() {

		driver.findElement(By.id("mobileNumber")).sendKeys("0");
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Mobile number should be 10 digits";

		String text = driver.findElement(By.xpath("//*[@id=\'mobileNumber.errors\']")).getText();
		assertEquals(expectedMsg, text);
	}

	@Test(priority = 11)
	public void testcourierDeliveryAreaEmpty() {

		driver.findElement(By.xpath("//*[contains(text(),'Local')]")).click();
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Courier delivery area is required";
		String text = driver.findElement(By.xpath("//*[@id=\'courierDeliveryArea.errors\']")).getText();
		assertEquals(expectedMsg, text);
	}

	@Test(priority = 12)
	public void testpacketWeightInGramsWrong() {

		driver.findElement(By.id("packetWeightInGrams")).sendKeys("0");
		driver.findElement(By.name("submit")).click();
		String expectedMsg = "Packet weight must be more then 0";

		String text = driver.findElement(By.xpath("//*[@id=\'packetWeightInGrams.errors\']")).getText();
		assertEquals(expectedMsg, text);
	}

	@Test(priority = 13)
	public void testcustomerCity() {
		String[] cityNames = {"Chennai", "Mumbai", "Delhi", "Bangalore", "Pune", "Kolkatta" };
		Select selectCity = new Select(driver.findElement(By.id("customerCity")));
		List<WebElement> technologyDropDown = selectCity.getOptions();
		for (int k = 0; k < technologyDropDown.size() - 1; k++) {
			assertEquals(cityNames[k], technologyDropDown.get(k).getText());
		} // for
	}

	@Test(priority = 14)
	public void testSubmitActionForOverWeight() {
		driver.findElement(By.id("customerName")).sendKeys("John");
		driver.findElement(By.id("customerCity")).sendKeys("Pune");
		driver.findElement(By.id("mobileNumber")).clear();
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
		driver.findElement(By.id("packetWeightInGrams")).clear();
		driver.findElement(By.id("packetWeightInGrams")).sendKeys("2500");

		driver.findElement(By.id("courierDeliveryArea1")).click();
		driver.findElement(By.id("courierDeliveryArea1")).sendKeys("Local");

		//check weightCheck.jsp page opens here
		driver.findElement(By.name("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("overweight"))));
		String resultText = driver.findElement(By.xpath("//h2[1]")).getText();

		WebElement courierDetails = driver.findElement(By.id("overweight"));
		assertNotNull(resultText);
		assertThat(resultText.startsWith("Sorry, courier is overweight!!"));
		//check hyperlink available
		WebElement link = driver.findElement(By.id("book"));
		assertNotNull(link);
		assertEquals("a", link.getTagName());
		//check href value
		assertTrue(link.getAttribute("href").equals("http://localhost:7070/showCourierBookingForm"));
		//click hyperlink click
		driver.findElement(By.id("book")).click();

	}

	@Test(priority = 15)
	public void testSubmitAction() {
		driver.findElement(By.id("customerName")).sendKeys("John");
		driver.findElement(By.id("customerCity")).sendKeys("Pune");
		driver.findElement(By.id("mobileNumber")).clear();
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
		driver.findElement(By.id("packetWeightInGrams")).clear();
		driver.findElement(By.id("packetWeightInGrams")).sendKeys("30");

		driver.findElement(By.id("courierDeliveryArea1")).click();
		driver.findElement(By.id("courierDeliveryArea1")).sendKeys("Local");

		driver.findElement(By.name("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("courierDetails"))));
		String resultText = driver.findElement(By.xpath("//h2[1]")).getText();

		WebElement courierDetails = driver.findElement(By.id("courierDetails"));
		assertNotNull(resultText);
		assertThat(resultText.startsWith("Courier Details"));
		//test expected element present on courierDetails page
		//check customerName
		WebElement customerName = driver.findElement(By.id("customerName"));
		assertNotNull(customerName);
		assertEquals("input", customerName.getTagName());
		assertEquals("text", customerName.getAttribute("type"));
		assertTrue(customerName.getAttribute("readOnly").equals("true"));

		//check MobileNumber
		WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
		assertNotNull(mobileNumber);
		assertEquals("input", mobileNumber.getTagName());
		assertEquals("text", mobileNumber.getAttribute("type"));
		assertTrue(mobileNumber.getAttribute("readOnly").equals("true"));
		
		//check deliveryArea 
		WebElement courierDeliveryArea = driver.findElement(By.id("courierDeliveryArea"));
		assertNotNull(courierDeliveryArea);
		assertEquals("input", courierDeliveryArea.getTagName());
		assertEquals("text", courierDeliveryArea.getAttribute("type"));
		assertTrue(courierDeliveryArea.getAttribute("readOnly").equals("true"));
		
		//check payableAmount
		WebElement payableAmount = driver.findElement(By.id("payableAmount"));
		assertNotNull(payableAmount);
		assertEquals("input", payableAmount.getTagName());
		assertEquals("text", payableAmount.getAttribute("type"));
		assertTrue(payableAmount.getAttribute("readOnly").equals("true"));
		
		//----------------------------------
				
		// testing submit button to see shipment and delivery dates page opened or not
		driver.findElement(By.name("submit")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("shipment"))));
		String resultText1 = driver.findElement(By.xpath("//h2[1]")).getText();
		WebElement shipment = driver.findElement(By.id("shipment"));
		assertNotNull(resultText1);
		assertThat(resultText.startsWith("Courier Shipment Details"));
		
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
		String resultText2 = driver.findElement(By.xpath("//div[1]")).getText();
		WebElement courierShipmentDetails = driver.findElement(By.id("message"));
		assertNotNull(resultText2);
		assertThat(resultText2.startsWith("CourierTracking Number:"));
		assertThat(resultText2.contains("Courier shipped on:"));
		assertThat(resultText2.contains("Expected delivery date:"));
		assertThat(resultText2.contains("Book Another Courier:"));
	}

}
