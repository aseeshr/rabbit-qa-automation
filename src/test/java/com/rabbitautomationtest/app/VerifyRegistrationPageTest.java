package com.rabbitautomationtest.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.TestCase;

public class VerifyRegistrationPageTest extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(groups={"registration"}, description="test for the registration page")
  public void testVerifyRegistrationPage() throws Exception {
    driver.get(baseUrl + "/mercuryregister.php");
    
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("asee");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("shrestha");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("0987654321");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("aseeshr");
    driver.findElement(By.name("address1")).clear();
    driver.findElement(By.name("address1")).sendKeys("thailand bangkok");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("bangkok");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("sathorn");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("10120");
    new Select(driver.findElement(By.name("country"))).selectByVisibleText("THAILAND");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("handsome");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("password");
    driver.findElement(By.name("register")).click();
  }
  
  @Test(groups={"registration.fields"}, description="test for the First Name")
  public void verifyFirstName() throws Exception {
	    driver.get(baseUrl + "/mercuryregister.php");
	    driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys("asee");
	    driver.findElement(By.name("register")).click();
	    Thread.sleep(1000);
	    Assert.assertTrue(driver.getPageSource().contains("asee"));
  }
  
  @Test(groups={"registration.fields"}, description="test for the Email")
  public void testEmail() throws Exception {
	    driver.get(baseUrl + "/mercuryregister.php");
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("aseeshr");
	    driver.findElement(By.name("register")).click();
	    Thread.sleep(1000);
	    Assert.assertTrue(driver.getPageSource().contains("aseeshr"));
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
