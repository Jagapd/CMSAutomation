package com.CrossovercmsAutomation.Operation;

import org.testng.annotations.Test;

import com.CrossovercmsAutomation.Base.BaseClass;
import com.CrossovercmsAutomation.PageObject.ContentPage;
import com.CrossovercmsAutomation.PageObject.EditPage;
import com.CrossovercmsAutomation.PageObject.NewPostPage;

public class CmsEditPost extends BaseClass{
	/*
	 * Test case to Edit Post in crossover tech
	 * 1. Log in to Admin Panel.
	 * 2. Click on Content Post.
	 * 3. Edit Title , Description 
	 * 4. Publish
	 * 5. Verify the edited content and title.
	 */
	
	@Test(priority=2)
	public void editCmsPost()
	{
		System.out.print("Executing CMS Edit Post");
		ContentPage content=new ContentPage(driver);
		NewPostPage postPage=new NewPostPage(driver);
		EditPage edit=new EditPage(driver);
		content.clickContentTab(driver);
		content.clickEditIcon(driver);
		edit.editTitle(driver);
		edit.editDescription(driver);
		edit.editImage(driver);
		content.clickSettingsMenuDropdown(driver);
		postPage.clickPublishNowOption(driver);
		content.clickContentTab(driver);
		content.verifyPost(driver);
		
		
	}
	

}
