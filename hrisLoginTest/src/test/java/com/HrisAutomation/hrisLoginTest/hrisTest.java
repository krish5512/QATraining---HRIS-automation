package com.HrisAutomation.hrisLoginTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class hrisTest {

	App appObject;
	TestTimesheet timeObject;

	public hrisTest()
	{
		appObject = new App();
	}
	@BeforeClass
	public void beforeClass(){
		appObject.launchHris();
	}

	@Test (priority = 0)
	public void NoPasswordTest() {
		appObject.NoPassword("p**********ar","");
		Assert.assertTrue(appObject.isPasswordEntryAnnotated());
	}   
	@Test (priority = 1)
	public void WrongPasswordTest() {
		Assert.assertTrue(appObject.WrongPassword("pr*********r","k*******3").contains("Invalid Login"));
	}   
	@Test (priority = 2)
	public void CorrectCredentialsTest() {
		Assert.assertTrue(appObject.CorrectCredentials("p**************r","K***********#").isloginpage());
	}  

	@Test (priority = 3)
	public void logoutUser()
	{
		Assert.assertTrue(appObject.logoutUserAccount().logoutHris(), "user logout successful");
	}

	@AfterClass
	public void afterClass() {
		appObject.closeBrowser();
	}

}

