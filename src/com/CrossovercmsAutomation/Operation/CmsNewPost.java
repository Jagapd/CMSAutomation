package com.CrossovercmsAutomation.Operation;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CrossovercmsAutomation.Base.BaseClass;
import com.CrossovercmsAutomation.PageObject.*;

public class CmsNewPost extends BaseClass{
	/*
	 * Test case to create Post in crossover tech
	 * 1. Log in to Admin Panel
	 * 2. Click on New post
	 * 3.Enter post title , description ,
	 * 4. Click on publish and publish now
	 * 5. Verify title content.
	 */
	
	@Test(priority=1)
	public void createNewPost() throws InterruptedException
	{
	NewPostPage postPage=new NewPostPage(driver);
	ContentPage content=new ContentPage(driver);
	Thread.sleep(1000);
	Reporter.log("Clicking on New post option ");
	postPage.clickNewPostOption(driver);
	Thread.sleep(1000);
	Reporter.log("Entering Post title ");
	postPage.enterPostTitle(driver);
	Thread.sleep(1000);
	Reporter.log("Entering Post Description ");
	postPage.enterPostDescription(driver);
	Thread.sleep(1000);
	Reporter.log("Entering image ");
	postPage.enterImageDescription(driver);
	Thread.sleep(1000);
	Reporter.log("Click on setting and publish ");
	content.clickSettingsMenuDropdown(driver);
	postPage.selectPublishOption(driver);
	Thread.sleep(1000);
	Reporter.log("Click on publish now ");
	postPage.clickPublishNowOption(driver);
	Thread.sleep(1000);
	Reporter.log("Click on content tab and verify post ");
	content.clickContentTab(driver);
	postPage.verifyPostTitle(driver);
		
	}

}
