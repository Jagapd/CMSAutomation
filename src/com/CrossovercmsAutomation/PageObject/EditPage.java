package com.CrossovercmsAutomation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {
	
	WebDriver driver;
	private By deleteImage = By.xpath(".//*[@class='image-cancel icon-trash']");
	private By newImageUploader = By.xpath(".//*[@class='ember-view gh-image-uploader']");
	private By editDescription =By.xpath(".//*[@id='entry-markdown-content']/textarea");
	private By editTitle =By.xpath(".//*[@class='ember-view gh-input']");
	private String image= "\\n ![](/content/images/2017/08/images.jpg)";
	
	 public  EditPage(WebDriver driver) {
	        this.driver = driver;
	}
	 
	
	public EditPage editTitle(WebDriver driver)
	{
		WebElement titleEdit = driver.findElement(editTitle);
		titleEdit.clear();
		titleEdit.sendKeys("Post Title Edited");
		return new EditPage(driver);
		
	}
	
	public EditPage editImage(WebDriver driver)
	{
		WebElement descriptionEdit = driver.findElement(editDescription);
		descriptionEdit.sendKeys(image);
		return new EditPage(driver);
		
	}
	
	public EditPage editDescription(WebDriver driver)
	{
		WebElement descriptionEdit = driver.findElement(editDescription);
		descriptionEdit.clear();
		descriptionEdit.sendKeys("Description Edited");
		return new EditPage(driver);
	}
	
	
  
}
