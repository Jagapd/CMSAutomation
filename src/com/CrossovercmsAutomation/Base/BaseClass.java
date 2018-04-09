package com.CrossovercmsAutomation.Base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.CrossovercmsAutomation.Utils.Constants;
import com.CrossovercmsAutomation.Utils.PropertyReader;
import com.beust.jcommander.Parameter;
import com.CrossovercmsAutomation.PageObject.*;

/**
 * Base Class - Contains details of browser functionality and their operations
 */

public class BaseClass {
	
	public WebDriver driver;
	CrossoverAdminLoginPage adminPage;
	
	/*
	 * Module to invoke browser based on parameters chrome,Firefox,IE.
	 * 
	 * Default parameter : chrome
	 */
	
	@BeforeClass
	 @Parameters("browser")
	 public void setup(@Optional("firefox")String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("firefox")){
			Reporter.log("Opening firefox driver");
        	System.setProperty("webdriver.gecko.driver","src\\com\\CrossovercmsAutomation\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();          
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
		}
            
         else if(browser.equalsIgnoreCase("chrome")){      
        	 Reporter.log("Opening default Chrome driver");
                System.setProperty("webdriver.chrome.driver","src\\com\\CrossovercmsAutomation\\driver\\chromedriver.exe");        
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
               
            }
           else if(browser.equalsIgnoreCase("ie")){
        	   Reporter.log("Opening IE");
        	    System.setProperty("webdriver.ie.driver","src\\com\\CrossovercmsAutomation\\driver\\IEDriver.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
            }
            else{
     
                throw new Exception("Browser not supported");
            }
		 PropertyReader property = new PropertyReader(Constants.configFile);
		 driver.get(property.getProperty("url"));
		 adminPage = new CrossoverAdminLoginPage(driver);
		 adminPage.adminSignIn(Constants.USER_NAME, Constants.PASSWORD, driver);
		             
        }
	@AfterClass
    public void destroy() {
		driver.quit();

	}
	}

