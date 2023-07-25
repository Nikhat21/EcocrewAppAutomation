package org.ecocrewFramework;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pickupAddressErrorValidationTest extends BaseTest {
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	RaiseContributionRequestPage raisecontribution;
	AddAddressPage addaddress;
	@Test
	public void addressErrorValidation() throws InterruptedException {
		loginPage = new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField("8197125121");
		loginPage.verifyOTP("1234");
		Thread.sleep(2000);
		//loginPage.surveyScreen();
		raiseRequest = new RaisePickupRequestPage(driver);
		raiseRequest.createOrder();
		raiseRequest.openCameraNewUser();	
		raisecontribution=new RaiseContributionRequestPage(driver);	
		Thread.sleep(3000);
		raisecontribution.selectRandomDate();
		raisecontribution.selectTime();
		raisecontribution.SelectTimeSlot();
		
		
		addaddress=new AddAddressPage(driver);
		addaddress.pickupAddresss();
		addaddress.newPickupAddress("dlf","");
		String expectedText = "address required";
		Assert.assertEquals(expectedText, addaddress.getAddAddressPickpup());
		
	}
	
	
}
