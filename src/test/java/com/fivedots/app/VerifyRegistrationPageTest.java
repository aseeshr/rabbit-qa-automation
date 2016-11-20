package com.fivedots.app;

import org.testng.annotations.Test;

import junit.framework.TestCase;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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

  @Test(description="test for the registration page")
  public void testVerifyRegistrationPage() throws Exception {
    driver.get(baseUrl + "/mercuryregister.php");
//    try {
//    	System.out.println(driver.getTitle());
//    } catch (Error e) {
//    	System.out.println("Some error " + e.toString());
//    }
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("sam");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("shrestha");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("0987654321");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("test@test.com");
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
    try {
    	System.out.println(driver.getTitle());
    } catch (Error e) {
    	System.out.println("Some error " + e.toString());
    }
//    try {
//      assertEquals(driver.findElement(By.cssSelector("b")).getText(), "Dear sam shrestha,");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
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

