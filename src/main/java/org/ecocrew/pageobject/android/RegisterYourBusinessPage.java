package org.ecocrew.pageobject.android;

import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterYourBusinessPage extends AndroidAction {
	AndroidDriver driver;

	public RegisterYourBusinessPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ProfileUpdateEcoCoinsCompleteProfile']")
	private WebElement ecocoins;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.HomeRegisterYourBusiness']")
	private WebElement RegisterYourBusiness;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.RegisterStaticScreenRegisterNow']")
	private WebElement RegisterNow;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.B2BRegisterScreenBusinessName']")
	private WebElement enterBusinessName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.B2BRegisterScreenBusinessGstNumber']")
	private WebElement enterGSTNumber;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRegisterScreenBusinessUploadImages']")
	private WebElement businessUploadImages;
	
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement address_Whileusingtheapp;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRegisterScreenBusinessLaunchCamera']")
	private WebElement businessLaunchCamera;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='com.sec.android.app.camera:id/bottom_background']")
	private WebElement clickCamera;
	
//	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Shutter']")
//	private WebElement clickCamera;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Done']")
	private WebElement done;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRegisterScreenBusinessEnterBusinessLocation']")
	private WebElement enterBusinessLocation;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AddBusinessAddressSearchForAddress']")
	private WebElement firstSearch;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddBusinessAddressSearchKey']")
	private WebElement secondSearch;
	
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.AddBusinessAddressSearchData'])")
	List<WebElement> searchAddressList;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddBusinessAddressEnterCompleteAddress']")
	private WebElement enterCompleteAddress;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddBusinessAddressCompleteAddressInput']")
	private WebElement completeAddressInput;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddBusinessAddressLandmarkInput']")
	private WebElement landmarkInput;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddBusinessAddressAddAddressButton']")
	private WebElement AddAddressButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BRegisterScreenBusinessConfirmRegistartion']")
	private WebElement confirmRegistartion;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you for your submission!']")
	private WebElement thankYou;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.RegisterCompleteBackToUserProfile']")
	private WebElement backToUserProfile;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your business profile is in review']")
	private WebElement businessProfileReviewMessage;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='OK']")
	private WebElement mobOk;
	
	
	
	
	public void registerYourBusinessButton() throws InterruptedException {
		Thread.sleep(2000);
	//	driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Register your business\").instance(0))");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Register your business\").instance(0));"));		
		RegisterYourBusiness.click();
		scrollToText("Register now");
		RegisterNow.click();
	}
	
	public void businessDetails() {
		scrollToText("Enter business location");

		enterBusinessName.sendKeys("Test");
		enterGSTNumber.sendKeys("Test");
		
	}
	public void uploadImages() throws InterruptedException {
		businessUploadImages.click();
		businessLaunchCamera.click();
		address_Whileusingtheapp.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
		mobOk.click();
		//driver.sendKeyEvent(KeyEvent.KEYCODE_CAMERA);
		//clickCamera.click();
		
	}
	
	
	
	
	
	public void businessLocation() {
		enterBusinessLocation.click();
		address_Whileusingtheapp.click();
	}
	public void search() {
		firstSearch.click();
		secondSearch.sendKeys("dlf");
		searchAddressList.get(1).click();
		enterCompleteAddress.click();
	}
	public void businessAddress() {
		completeAddressInput.sendKeys("test address");
		landmarkInput.sendKeys("test landmark");
		AddAddressButton.click();
		
	}
	
	public void confirm() {

		scrollToText("Confirm registration");
		confirmRegistartion.click();
	}
	 public String getThankyouText() {
		 return thankYou.getText();
	 }
	
	public void backToProfile() {
		 backToUserProfile.click();

	}
	public String reviewMessage() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Raise pickup request\").instance(0));"));
		//scrollToText("Raise pickup request");
		return businessProfileReviewMessage.getText();
		

	}
	
}
