package org.ecocrew.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class B2BOrderPage {
	AndroidDriver driver;

	public B2BOrderPage(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.HomeBusinessViewBussinessProfile']")
	private WebElement view;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BHomeScreenSwitchProfile']")
	private WebElement switchProfile;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.HomeSwitchProfile']")
	private WebElement homeSwitchProfile;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRaisePickupRequest']")
	private WebElement b2bpickupRequest;
	
	
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BRaiseOneTimePickupRequest']")
	private WebElement b2bOneTimepickupRequest;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimePickupShowDatePicker']")
	private WebElement b2bOneTimeDatePicker;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='24 July 2023']")
	private WebElement b2bDate;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement okButton;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='24 July 2023']")
	private WebElement selectDate;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimePickupSelectTime']")
	private WebElement b2bTime;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimePickupTimeslot']")
	List<WebElement> selectTime;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimeOrderSelectMoneyAcceptance']")
	private WebElement selectMoneyMode;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimePickupPaymentMode']")
	List<WebElement> selectPaymentMode;
	

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BOneTimeOrderSubmitData']")
	private WebElement ConfirmPickup;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BPickupConfirmedBackToHome']")
	private WebElement confirmedBackToHome;
	
	
	//View OrderDetails
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOrderTrackingViewOrder']")
	private WebElement viewOrderDetails;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BOrderDetailsEditPickup']")
	private WebElement editPickup;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOrderDetailsCancelPickup']")
	private WebElement cancelPickup;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.B2BOrderDetailsAreYouSureEditProceed']")
	private WebElement editProceed;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOrderDetailsAreYouSureEditClose']")
	private WebElement editCancel;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.B2BOneTimePickupShowDatePicker']")
	private WebElement editDate;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.CancelViewOnCancel']")
	private WebElement cancelViewOnCancel;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.CancelViewOnDontCancel']")
	private WebElement cancelViewOnDontCancel;
	
	public void viewLink() {
		view.click();
	}
	
	public void switchProfileLink() {
		homeSwitchProfile.click();
	}
	
	public void b2bOrder() {
		b2bpickupRequest.click();
	}
	public void oneTime() {
		b2bOneTimepickupRequest.click();
	}
	public void selectDate() {
		b2bOneTimeDatePicker.click();
		b2bDate.click();
		okButton.click();
		
	}
	
	public void selectTimeSlot() {
		b2bTime.click();
		selectTime.get(1).click();
	}
	
	public void moneyAcceptanceMode() {
		selectMoneyMode.click();
		selectPaymentMode.get(0).click();
	}
	
	public void confirm() {
		ConfirmPickup.click();
	}
	
	public void backToHome() {
		confirmedBackToHome.click();
	}
	
}
