package com.CrossovercmsAutomation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CrossovercmsAutomation.Utils.Constants;

public class CrossoverAdminLoginPage {
	
	private WebElement element;
	WebDriver driver;
	private By emailId=By.xpath(".//*[@class ='email ember-view gh-input']");
	private By password=By.xpath(".//*[@class ='password ember-view gh-input']");
	private By signIn=By.xpath(".//*[@class ='login btn btn-blue btn-block ember-view']");
	
	  public  CrossoverAdminLoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
	
	public CrossoverAdminLoginPage adminSignIn(String userName,String pass,WebDriver driver)
	{
		driver.findElement(emailId).sendKeys(Constants.USER_NAME);
		driver.findElement(password).sendKeys(Constants.PASSWORD);
		driver.findElement(signIn).click();
		return this;
	}
	
			
			


}
