package org.ecocrew.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompleteYourProfilePage {
	
	public AndroidDriver driver;
	public CompleteYourProfilePage(AndroidDriver driver) {
        //super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	

	
	
	
}
