package com.HrisAutomation.hrisLoginTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class hrisTest {
	
   WebDriver driver;
  App appObject = new App();
 
 @Test 
  public void NoPasswordTest() {
	  appObject.NoPassword("prkrishnakumar","");
      Assert.assertTrue(appObject.isPasswordEntryAnnotated());  

  }  
 
  @Test 
  public void WrongPasswordTest() {
	  Assert.assertTrue(appObject.WrongPassword("prkrishnaar","krishna123").contains("Invalid Login"));
	  
  }
   
  @Test 
  public void CorrectCredentialsTest() {
	 Assert.assertTrue(appObject.CorrectCredentials("prkrishnakumar","***********").isloginpage());

  }

  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  appObject.launchHris();
	  }

  @AfterClass
  public void afterClass() {
 driver.quit();
  }

  }
