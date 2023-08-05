package org.ecocrew.pageobject.android;

import java.util.ArrayList;
import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaisePickupRequestPage extends AndroidAction{
	AndroidDriver driver;
	public RaisePickupRequestPage(AndroidDriver driver) {
		  super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.FirstPickupRequestRaisePickup']")
	private WebElement FirstPickupRequestRaisePickup;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.RaisePickupOpenCameraButton']")
	private WebElement RaisePickupOpenCameraButton;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement WhileUsingTheApp;
	
	@AndroidFindBy(id = "ecocrew.CustomCameraLaunchCameraButton")
	private WebElement CameraButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraLaunchImageButton']")
	private WebElement galleryAllowButton;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement allowButton;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.google.android.documentsui:id/icon']")
	List<WebElement> images;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.google.android.documentsui:id/action_menu_select']")
	private WebElement selectImages;
			
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraSubmitButton']")
	private WebElement CameraSubmitButton;
		
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraLaunchCameraButton']")
	WebElement mobilecamera;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraSubmitButton']")
	WebElement mobilecameraDone;
	
	public void createOrder() {
		FirstPickupRequestRaisePickup.click();
		RaisePickupOpenCameraButton.click();
	}
	
	
	public void openCameraNewUser() {
		WhileUsingTheApp.click();
		galleryAllowButton.click();
		allowButton.click();	
		int count =images.size();	
		System.out.println(count);
		for(int i=0;i<count;i++) {	
		images.get(i).click();		
		}
		selectImages.click();
		CameraSubmitButton.click();
	}
	
	
	
	
	public void mobCamera() throws InterruptedException {
		WhileUsingTheApp.click();
		mobilecamera.click();
		Thread.sleep(2000);
		mobilecameraDone.click();
	}
	
	public void mobCamerauser() throws InterruptedException {
		mobilecamera.click();
		Thread.sleep(2000);
		mobilecameraDone.click();
	}
	
	public void openCameraExistingUser() throws InterruptedException {
		galleryAllowButton.click();
		//allowButton.click();	
		Thread.sleep(3000);
		int count =images.size();	
		System.out.println(count);
		for(int i=0;i<count;i++) {	
		images.get(i).click();			
		}
		selectImages.click();
		CameraSubmitButton.click();
			
	}
	
	
	
	
}


