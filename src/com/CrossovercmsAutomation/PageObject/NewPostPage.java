package com.CrossovercmsAutomation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewPostPage {
	WebDriver driver;
	private By post=By.xpath(".//*[@class='gh-nav-list gh-nav-main']/li[1]");
	private By postTitle=By.xpath(".//*[@id='entry-title' or @class='ember-view gh-input']");
	private By description=By.xpath(".//*[@class='entry-markdown js-entry-markdown active']//section/textarea");
	private By publish=By.xpath(".//*[@class='dropdown-menu dropdown-triangle-bottom-right']/li[1]/a");
	private By publishNow=By.xpath(".//*[@class='view-actions']//section/button[1]");
	private By verifypost=By.xpath(".//*[@class='posts-list']//h3");
	static String title="Post on Aug";
	static String NewImage = System.getProperty("user.dir")+"\\resource\\test2.png";
	
	 public  NewPostPage(WebDriver driver) {
	        this.driver = driver;
	}
	 
	 public NewPostPage clickNewPostOption(WebDriver driver){
			
			WebElement post1 = driver.findElement(post);
			post1.click();
			String Actual = "Editor - Crossover TechTrial Blog";
			String Expected=driver.getTitle();
			Assert.assertTrue(Actual.equalsIgnoreCase(Expected));
			return new NewPostPage (driver);
		}
	 
	 public NewPostPage enterPostTitle(WebDriver driver) throws InterruptedException{
			
			WebElement postTitle1 = driver.findElement(postTitle);
			postTitle1.click();
			postTitle1.sendKeys(title);
			Assert.assertTrue("Editor - Crossover TechTrial Blog".contains(driver.getTitle()));
			return new NewPostPage (driver);
			
		}
	 
	 public NewPostPage enterImageDescription(WebDriver driver) {

			WebElement descriptiontemp = driver.findElement(description);
			descriptiontemp.sendKeys(NewImage);
			return new NewPostPage (driver);
			
		}
	 
	 public NewPostPage enterPostDescription(WebDriver driver){
			
			WebElement Description1 = driver.findElement(description);
			Description1.sendKeys("Post on Aug description\n");
			return new NewPostPage (driver);
			
		}
	 
	 public NewPostPage selectPublishOption(WebDriver driver){
			
			WebElement publishtemp = driver.findElement(publish);
			publishtemp.click();
			Assert.assertEquals("Publish Now", publishtemp.getText());
			return new NewPostPage (driver);
			
		}
	 
	 public NewPostPage clickPublishNowOption(WebDriver driver){
			
			WebElement publishtemp = driver.findElement(publishNow);
			publishtemp.click();
			String title=driver.getTitle();
			String afterpublishtitle = "Editor - Crossover TechTrial Blog";
			String Expectedtitle=driver.getTitle();
			Assert.assertTrue(Expectedtitle.equalsIgnoreCase(afterpublishtitle));
			return new NewPostPage (driver);
	 }
	 
	 public  NewPostPage verifyPostTitle(WebDriver driver){
			
			WebElement verifyposttemp = driver.findElement(verifypost);
			String verifyposttitle = verifyposttemp.getText();
			Assert.assertTrue(verifyposttitle.contains(title));
			return new NewPostPage (driver);
			
		}
			

	 
	 
	

}
