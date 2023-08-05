package org.ecocrew.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditOrderDetailsPage {
AndroidDriver driver;
	
	public EditOrderDetailsPage(AndroidDriver driver) {
       //super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.PickupDetailEditPickupButton']/android.widget.TextView")
	private WebElement editPickupButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.PickupDetailPopupEditProceed']/android.widget.TextView")
	private WebElement popupProceed;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.PickupDetailPopupEditCancel']/android.widget.TextView")
	private WebElement popupCancel;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ScrapDetailsShowDatePicker']")
	private WebElement editDatepicker;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='02 August 2023']")
	private WebElement otherDate;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement okButton;

	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ScrapDetailsSelectTimeSlot']")
	private WebElement editTimeSlot;
	
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ScrapDetailsTimeslot']")
	List<WebElement> editTimeSlotdropdown;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.ScrapDetailsInstruction']")
	private WebElement editInstruction;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.ScrapDetailsContinueButton']/android.widget.TextView")
	private WebElement continueButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ScrapDetailsClosingModel']")
	private WebElement close;
	
	public void editPickupOrder()
	{
		editPickupButton.click();
	}
	
	public void popupProceedBtn() {
		popupProceed.click();
	}
	
	public void editPickupDate() {
		editDatepicker.click();
	}
	
	public void editDate() {
		otherDate.click();
		okButton.click();
	}
	
	public void Selecttimeslot() {
		editTimeSlot.click();
	}
	
	public void pickTimeSlot() {
		editTimeSlotdropdown.get(0).click();
	}
	public void enterInstruction() {
		editInstruction.sendKeys("testgkkn");
	}

	public void contiune() {
		continueButton.click();
		close.click();
	}
	
	
	
	
	
	
	
}
