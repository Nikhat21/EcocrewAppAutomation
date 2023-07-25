package org.ecocrewFramework;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class RaiseContributionErrorValidationTest extends BaseTest {
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	RaiseContributionRequestPage raisecontribution;
	AddAddressPage addaddress;

	@BeforeMethod
	public void preSetup() {
		// adb shell dumpsys window | find "mCurrentFocus" ->for windows

		// screen to home page
		Activity activity = new Activity("com.ecocrew.app.sit", "com.ecocrew.app.MainActivity");
		driver.startActivity(activity);
	}

	@Test(priority = 1)
	public void raiseContributionDateError() throws InterruptedException {

		loginPage = new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField("8444444444");
		loginPage.verifyOTP("1234");
		Thread.sleep(2000);
		loginPage.surveyScreen();
		raiseRequest = new RaisePickupRequestPage(driver);
		raiseRequest.createOrder();
		raiseRequest.openCameraNewUser();

		raisecontribution = new RaiseContributionRequestPage(driver);
		raisecontribution.confirmPickupButton();
		String expectedText = "Please select date";
		Assert.assertEquals(expectedText, raisecontribution.getSelectDateErrorMessage());

	}

	@Test(priority =2)
	public void raiseContributionTimeError() throws InterruptedException {

		loginPage = new NewUserLoginPage(driver);
		// loginPage.welcomeScreens();
		// loginPage.inputField("8197125118");
		// loginPage.verifyOTP("1234");
		Thread.sleep(2000);
		// loginPage.surveyScreen();
		raiseRequest = new RaisePickupRequestPage(driver);
		raiseRequest.createOrder();
		raiseRequest.openCameraExistingUser();

		raisecontribution = new RaiseContributionRequestPage(driver);
		raisecontribution.selectRandomDate();
		raisecontribution.confirmPickupButton();
		Assert.assertEquals("Please select time", raisecontribution.getSelectTimeErrorMessage());

	}

	@Test(priority = 3)
	public void pickupAddressErrorValidation() throws InterruptedException {
		Thread.sleep(3000);
//		loginPage = new NewUserLoginPage(driver);
//		loginPage.welcomeScreens();
//		loginPage.inputField("8198909088");
//		loginPage.verifyOTP("1234");
		Thread.sleep(2000);
	//	loginPage.surveyScreen();

		
		raiseRequest = new RaisePickupRequestPage(driver);
		raiseRequest.createOrder();
		raiseRequest.openCameraExistingUser();

		raisecontribution = new RaiseContributionRequestPage(driver);
		raisecontribution.selectRandomDate();
		raisecontribution.selectTime();
		raisecontribution.SelectTimeSlot();
		raisecontribution.confirmPickupButton();
		Assert.assertEquals("Please provide Address details..", raisecontribution.getPickupAddressErrorMessage());

	}

	@Test(priority = 4)
	public void moneyAcceptanceErrorValidation() throws InterruptedException {
//		loginPage = new NewUserLoginPage(driver);
//		loginPage.welcomeScreens();
//		loginPage.inputField("8198910081");
//		loginPage.verifyOTP("1234");
//		Thread.sleep(2000);
//		loginPage.surveyScreen();
		raiseRequest=new RaisePickupRequestPage(driver);		
		raiseRequest.createOrder();
		raiseRequest.openCameraExistingUser();
		
		raisecontribution=new RaiseContributionRequestPage(driver);	
		raisecontribution.selectRandomDate();
		raisecontribution.selectTime();
		raisecontribution.SelectTimeSlot();
		addaddress.pickupAddresss();
		addaddress.newPickupAddress("dlf","Test");
		raisecontribution.confirmPickupButton();
		Assert.assertEquals("Please provide payment Details..", raisecontribution.getPaymentErrorMessage());

	}
		
//	@Test
//	public void timeslotFullErrorValidation() throws InterruptedException {
//		loginPage = new NewUserLoginPage(driver);
//		loginPage.welcomeScreens();
//		loginPage.inputField("8197125150");
//		Thread.sleep(2000);
//		loginPage.verifyOTP("1234");
//		Thread.sleep(2000);
//	//	loginPage.surveyScreen();
//		raiseRequest = new RaisePickupRequestPage(driver);
//		raiseRequest.createOrder();
//		raiseRequest.openCameraNewUser();
//
//		raisecontribution = new RaiseContributionRequestPage(driver);
//		raisecontribution.selectRandomDate();
//		raisecontribution.selectTime();
//		
//		String expectedText = "Sorry!";
//		Assert.assertEquals(expectedText, raisecontribution.getTimeSlotFullErrorMessage());
//	}
	
	
	

}
