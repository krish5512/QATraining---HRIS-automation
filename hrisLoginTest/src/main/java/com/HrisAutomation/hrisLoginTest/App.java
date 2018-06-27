package com.HrisAutomation.hrisLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class App 
{
   WebDriver driver;	
	@FindBy (id = "txtUserName")
	private WebElement username;
	
	@FindBy (id = "txtPassword")
	private WebElement password;
	
	@FindBy (name = "Submit")
	private WebElement submitButton;
	
	public WebElement GetUserNameEntry(){
		   return this.username;
	   }
	   
	   public WebElement GetPasswordEntry()
	   {
		   return this.password;
	   }
	
	
   public void fillCredentials(String username,String password)
   {
	   System.out.println(username);
	   System.out.println(password);

	   GetUserNameEntry().sendKeys(username);
	   GetPasswordEntry().sendKeys(password);
	   driver.findElement(By.linkText("Sign In")).click();
   }

public String WrongPassword(String username, String password) {
            fillCredentials(username,password);
            return getErrorMessageElement().getText();
}

private WebElement getErrorMessageElement() {
    return this.driver.findElement(By.cssSelector(".alert-error"));
}

public void launchHris() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\prkrishnakumar\\eclipse-workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://hris.qainfotech.com/login.php");
	  Thread.sleep(2000);
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
   
}
