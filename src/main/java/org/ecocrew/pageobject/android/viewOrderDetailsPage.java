package org.ecocrew.pageobject.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class viewOrderDetailsPage {

	AndroidDriver driver;

	public viewOrderDetailsPage(AndroidDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='ecocrew.mainBottomTabBarHome']")
	private WebElement home;
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailDateText']")
	private WebElement pickupDetailDateText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailTimeText']")
	private WebElement pickupDetailTimeText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailInstructionText']")
	private WebElement pickupDetailInstructionText;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailPaymodeText']")
	private WebElement PickupDetailPaymodeText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailPickupAddressText']")
	private WebElement pickupDetailPickupAddressText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailExecutiveAssignedNameText']")
	private WebElement pickupAssignedNameText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.PickupDetailExecutiveAssignedContactText']")
	private WebElement pickupAssignedContactText;
	
	public void homePage() {
		home.click();
		
	}
	
	public String dateVerification() {
		String pickupDetailsDate=pickupDetailDateText.getText();
		System.out.println("pickupDetailsDate" +pickupDetailsDate);
		return pickupDetailsDate;
		
	}
	
	public String timeVerification() {
		String pickupDetailsTime=pickupDetailTimeText.getText();
		System.out.println("pickupDetailsTime" +pickupDetailsTime);
		return pickupDetailsTime;
		
	}
	
	public String instructionVerification() {
		String pickupDetailsinstruction=pickupDetailInstructionText.getText();
		System.out.println("pickupDetailsinstruction" +pickupDetailsinstruction);
		return pickupDetailsinstruction;
		
	}
	
	public String PaymodeVerification() {
		String paymentDetails=PickupDetailPaymodeText.getText();
		System.out.println("monel acceptance details :" +paymentDetails);
		return paymentDetails;

	}
	
	public String addressDetailsVerification() {
		String addressDetails=pickupDetailPickupAddressText.getText();
		System.out.println("pickup address details :" +addressDetails);
		return addressDetails;
		}
	
	
}
