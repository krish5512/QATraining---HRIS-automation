package com.HrisAutomation.hrisLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class App 
{
	static WebDriver driver;	

	public WebElement GetUserNameEntry(){
		return this.driver.findElement(By.id("txtUserName"));
	}

	public WebElement GetPasswordEntry()
	{
		return this.driver.findElement(By.id("txtPassword"));
	}

	public void launchHris() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prkrishnakumar\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
	}

	public void fillCredentials(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
		GetUserNameEntry().clear();
		GetPasswordEntry().clear();
		GetUserNameEntry().sendKeys(username);
		GetPasswordEntry().sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[2]/div/input")).click();
	}
	public String WrongPassword(String username, String password) {
		fillCredentials(username,password);
		return getErrorMessageElement().getText();
	}
	private WebElement getErrorMessageElement() {
		return this.driver.findElement(By.cssSelector(".alert-error"));
	}

	public String NoPassword(String username ,String password) {
		fillCredentials(username,password);
		return driver.findElement(By.id("txtPassword")).getAttribute("class");
	}
	public TestTimesheet CorrectCredentials(String username, String password) {
		fillCredentials(username,password);
		return new TestTimesheet(driver);
	}
	public Boolean isPasswordEntryAnnotated(){
		return GetPasswordEntry().getAttribute("style").contains("red");
	}
	public TestTimesheet logoutUserAccount()
	{
		return new TestTimesheet(driver);
	}
	public void closeBrowser() {
		driver.quit();
	}

}
