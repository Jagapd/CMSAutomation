package com.CrossovercmsAutomation.Operation;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.CrossovercmsAutomation.Base.BaseClass;
import com.CrossovercmsAutomation.PageObject.ContentPage;
import com.CrossovercmsAutomation.PageObject.EditPage;
import com.CrossovercmsAutomation.PageObject.NewPostPage;


public class CmsDeletePost extends BaseClass {
	/*
	 * Test case to Deelte Post in crossover tech
	 * 1. Log in to Admin Panel.
	 * 2. Click on Content Post.
	 * 3. Click on Delete from settings
	 * 4. Click on Delete pop up.
	 */
	@Test(priority=3)
	public void deletePost() throws InterruptedException
	{
	Reporter.log("Executing Delete post");
	ContentPage content=new ContentPage(driver);
	NewPostPage postPage=new NewPostPage(driver);
	EditPage edit=new EditPage(driver);
	content.clickContentTab(driver);
	content.totalPostCount(driver);
	content.clickEditIcon(driver);
	content.clickSettingsMenuDropdown(driver);
	content.deletePost(driver);
	content.deletePostPopup(driver);
	
	}

}
