package com.CrossovercmsAutomation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.List;

public class ContentPage {

	private WebDriver driver;
	WebDriverWait wait;
	private By content = By.xpath(".//*[text() = 'Content']");
	private By postButton=By.xpath(".//*[@class='posts-list']/li[1]/a/h3");
	private By postEditIcon=By.xpath(".//*[@class='btn btn-minor post-edit ember-view']/i");
	private By SettingsMenuDropdown=By.xpath(".//*[@class='ember-view splitbtn js-publish-splitbutton']/button[2]");
	private By deletePostDropDown=By.xpath(".//*[@class='dropdown-menu dropdown-triangle-bottom-right']/li[4]/a");
	private By deletePost=By.xpath(".//*[@class='btn btn-red ember-view']");
	private By contentTable=By.xpath(".//*[@class='view-container']/section[1]");
	private By contentTableCount=By.xpath(".//*[@class='posts-list']/li");
	
	 public  ContentPage(WebDriver driver) {
	        this.driver = driver;
	}
	
	public ContentPage clickContentTab(WebDriver driver)
	{
		Reporter.log("Clicking on Content tab");
		WebElement content1 = driver.findElement(content);
		content1.click();
	   String ActualContentText="Content";
	   String ExpectedContentText=content1.getText();
	   Assert.assertTrue(ActualContentText.contains(ExpectedContentText));
	   return this;	
	}
	
	public ContentPage verifyPost(WebDriver driver) {
		Reporter.log("Verifying post");
		WebElement Post = driver.findElement(postButton);
		if(Post.isDisplayed() || Post.isEnabled()){
			Post.click();
			String text = "Post Title Edited";
			String verifyposttitle = Post.getText();
			Assert.assertTrue(text.contains(verifyposttitle));       
		}
        else System.out.println("No Post ");
		return new ContentPage (driver);
		
	}
	
	public ContentPage clickEditIcon(WebDriver driver){
		
		WebElement post = driver.findElement(postEditIcon);
		if(post.isDisplayed() || post.isEnabled()){
			post.click();
			String expectedEditTitle="Content - Crossover TechTrial Blog";
			String title=driver.getTitle();
			Assert.assertTrue(expectedEditTitle.contains(title));
		}
		else System.out.println("No Post to Edit");
		return new ContentPage (driver);
		
	}
	
	public  ContentPage clickSettingsMenuDropdown(WebDriver driver)
	{
	Reporter.log("Clicking on dropdown");
	WebElement settingsMenu = driver.findElement(SettingsMenuDropdown);
	settingsMenu.click();
	String menu=settingsMenu.getText();
	Assert.assertTrue("TOGGLE SETTINGS MENU".contains(menu));
	return new ContentPage(driver);
		
	}
	public ContentPage deletePost(WebDriver driver){
		WebElement postDelete = driver.findElement(deletePostDropDown);
		postDelete.click();
		String actualDeleteText="Delete Post";
		String expectedDeleteText=postDelete.getText();
		Assert.assertTrue(actualDeleteText.contains(expectedDeleteText));
		return new ContentPage (driver);	
	}

	public ContentPage deletePostPopup(WebDriver driver){
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(deletePost));
		WebElement deletePostPopup = driver.findElement(deletePost);
		deletePostPopup.click();
		String actualDeletePopupText="Content - Crossover TechTrial Blog";
		String expectedDeletePopupText=driver.getTitle();
		Assert.assertTrue(actualDeletePopupText.contains(expectedDeletePopupText));
		return new ContentPage (driver);	
	}

	public ContentPage totalPostCount(WebDriver driver){
		WebElement conTable = driver.findElement(contentTable);
		List<WebElement> contentTableList = conTable.findElements(contentTableCount);
		int count = contentTableList.size();
		for(int i=0;i<=count;i++){  
		        if(count == 0){ 
		        	System.out.println("You Haven't Written Any Posts Yet! ");
		            break;  
		        } 
		       
		  	}
		  return new ContentPage (driver);
	}
	
}
