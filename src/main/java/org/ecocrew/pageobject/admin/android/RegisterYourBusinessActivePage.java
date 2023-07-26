package org.ecocrew.pageobject.admin.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterYourBusinessActivePage {
	
		AndroidDriver driver;

		public RegisterYourBusinessActivePage(AndroidDriver driver) {
			//super(driver);
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		}
		
		
		@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.HomeBusinessViewBussinessProfile']")
		private WebElement view;
		
		@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.HomeSwitchProfile']")
		private WebElement homeSwitchProfile;
		
		@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.B2BHomeScreenBusinessName']")
		private WebElement welcome;
		
		
		public void viewLink() {
			view.click();
			//homeSwitchProfile.click();
		}
		
		public void welcomeBusiness() {
			welcome.getText();
		}
		
		
		
		
		
}
