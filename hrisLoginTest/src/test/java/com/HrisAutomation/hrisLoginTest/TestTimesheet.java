package com.HrisAutomation.hrisLoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestTimesheet {

	WebDriver driver;

	public TestTimesheet(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean isloginpage() {
		boolean value = false;
		WebElement tableContent = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/time-sheet/div/div[2]/div/div/time-sheet-panel/table"));
		if(tableContent.isDisplayed())
		{
			value = true;
		}
		
		return value;
	}

	public boolean logoutHris() {
		boolean test = false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement userText = driver.findElement(By.id("txtUserName"));
		if(userText.isDisplayed()) {
			test = true;
		}		
		return test;

	}
}
