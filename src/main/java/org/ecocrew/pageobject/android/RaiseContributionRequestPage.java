package org.ecocrew.pageobject.android;

import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RaiseContributionRequestPage extends AndroidAction {

	AndroidDriver driver;

	public RaiseContributionRequestPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='RAISE A CONTRIBUTION REQUEST']")
	private WebElement rasieContributionHeading;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupShowDatePicker']")
	private WebElement selectDate;
	

	@AndroidFindBy(id = "android:id/date_picker_header_date")
	private WebElement datePicker;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement okButton;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupShowDatePicker']/android.widget.TextView")
	private WebElement displayDate;
	

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupSelectTimeSlot']")
	private WebElement selectTime;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupTimeSlot']")
	List<WebElement> timeSlot;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupSelectTimeSlot']/android.widget.TextView")
	private WebElement displayTime;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.OneTimePickupInstruction']")
	private WebElement instructions;
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.OneTimePickupAddressPaymentName1']")
	private WebElement paymentName;


	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.usingAddressOnMyAddress']")
	private WebElement useThis;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupSelectPayment']")
	private WebElement moneyAcceptanceMode;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id ='ecocrew.paymentModeSelect']")
	List<WebElement> paymentMode;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.paymentModeSelectButton']")
	private WebElement paymentContinue;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.OneTimePickupConfirmButton']")
	private WebElement pickupConfirmButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.PickupConfirmedSubmitData']")
	private WebElement checkoutEcostoreButton;

	// Select date

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='02 August 2023']")
	private WebElement otherDate;

	// Error validation elements
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupDateError']/android.widget.TextView")
	private WebElement oneTimePickupDateError;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupTimeError']/android.widget.TextView")
	private WebElement oneTimePickupTimeError;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupAddressError']/android.widget.TextView")
	private WebElement oneTimePickupAddressError;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupPaymentError']/android.widget.TextView")
	private WebElement OneTimePickupPaymentError;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupSlotFullView']/android.widget.TextView[1]")
	private WebElement timeSlotFullError;
	
	

	public String getHeading() {
		String raisePickupHeading = rasieContributionHeading.getText();
		return raisePickupHeading;
	}

	public void selectTodaysDate() throws InterruptedException {
		selectDate.click();
		Thread.sleep(2000);
		String date = datePicker.getText();
		System.out.println("=========================" + date);
		okButton.click();
	}

	public void selectRandomDate() throws InterruptedException {
		selectDate.click();
		Thread.sleep(2000);
		//otherDate.click();
		okButton.click();
	}
	
	public String getDate() {
		String selectedDate=displayDate.getText();
		
		System.out.println("selectedDate: " +selectedDate);
		return selectedDate;
	}
	
	public void selectTime() {
		selectTime.click();
	}
	
	public void SelectTimeSlot() {	
		for(WebElement list : timeSlot) {
			String timeSlotList=list.getText();
			System.out.println("timeeeeeeeeeeeee" +timeSlotList);			
		}
		timeSlot.get(0).click();
		scrollToText("Confirm pickup");
		instructions.sendKeys("Testing ecocrew instruction");
		
	}
	
	
	
	
	public String getTime() {
		String selectedTime=displayTime.getText();
		System.out.println("selectedTime: " +selectedTime);
//		System.out.println(selectedTime.replace(selectedTime, ""));
		
        String s=selectedTime.substring(0,selectedTime.lastIndexOf("("));
        
        System.out.println("999999999999999999999999999999999:: " +s);
      
		return s;
		
	}
	
	
	public String getInstruction() {
		String instr=instructions.getText();
		System.out.println("Instructions  "+instr);
		return instr;
	}
	
	
	
	public String getPaymentName() {
		String paymentMode=paymentName.getText();
		System.out.println("Payment mode :" +paymentMode);
		return paymentMode;
	}
	
	
	public void moneyacceptance() {
		scrollToText("Confirm pickup");
		moneyAcceptanceMode.click();
		for (WebElement option : paymentMode) {
			System.out.println("Values are = " + option.getText());
			paymentMode.get(0).click();
		}
		paymentContinue.click();
	}

	public void confirmPickupButton() {
		scrollToText("Confirm pickup");
		pickupConfirmButton.click();
		
	}
	
	
	public void checkoutEcoStoreButton(){
		checkoutEcostoreButton.click();
	}

	public String getSelectDateErrorMessage() {
		String dateErrorMessage = oneTimePickupDateError.getText();
		System.out.println("-----------" +dateErrorMessage);
		return dateErrorMessage;
	}

	public String getSelectTimeErrorMessage() {
		String timeErrorMessage = oneTimePickupTimeError.getText();
		System.out.println("-----------" +timeErrorMessage);
		return timeErrorMessage;
	}

	public String getPickupAddressErrorMessage() {
		String pickupAddressErrorMessage = oneTimePickupAddressError.getText();
		System.out.println("-----------" +pickupAddressErrorMessage);
		return pickupAddressErrorMessage;
	}
	public String getPaymentErrorMessage() {
		String paymentErrorMessage = OneTimePickupPaymentError.getText();
		System.out.println("-----------" +paymentErrorMessage);
		return paymentErrorMessage;
	}
	
	public String getTimeSlotFullErrorMessage() {
		String slotsFullErrorMessage = timeSlotFullError.getText();
		System.out.println("-----------" +slotsFullErrorMessage);
		return slotsFullErrorMessage;
	}
	
	
	
//	public void saveaddressCheckbox() {
//		Boolean defaultcheckbox=saveAddressCheckbox.isSelected();
//		System.out.println(defaultcheckbox);
//	}
	
	
	
		
	}
	

