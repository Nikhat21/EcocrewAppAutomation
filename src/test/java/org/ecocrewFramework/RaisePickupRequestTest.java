package org.ecocrewFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.CancelPickupOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.ecocrew.pageobject.android.viewOrderDetailsPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RaisePickupRequestTest extends BaseTest {
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	RaiseContributionRequestPage raisecontribution;
	CancelPickupOrderPage cancelPickupOrder;
	viewOrderDetailsPage vieworderdetails;
	AddAddressPage addAddress;
	 
	 
	@Test(dataProvider="getData" , groups= {"Smoke"})
	public void raisePickupRequest(String mobileNumber,String OTP) throws InterruptedException {
		loginPage= new NewUserLoginPage(driver);
	  	loginPage.welcomeScreens();	
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);	
		Thread.sleep(2000);
		loginPage.surveyScreen();		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='ecocrew.FirstPickupRequestRaisePickup']/android.widget.TextView")),"text" , "Raise pickup request"));
		raiseRequest=new RaisePickupRequestPage(driver);		
		raiseRequest.createOrder();
		//raiseRequest.openCameraNewUser();
		raiseRequest.mobCamera();
		raisecontribution=new RaiseContributionRequestPage(driver);	
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupShowDatePicker']/android.widget.TextView/android.widget.TextView")),"text" , "Select a date"));
		String raisecontributionHeading=raisecontribution.getHeading();
		Assert.assertEquals(raisecontributionHeading,"RAISE A CONTRIBUTION REQUEST");
		raisecontribution.selectRandomDate();
		//raisecontribution.getDate();
		raisecontribution.selectTime();
		raisecontribution.SelectTimeSlot();
		 String time1=raisecontribution.getTime();
         String instruction=raisecontribution.getInstruction();

		addAddress = new AddAddressPage(driver);
		addAddress.pickupAddresss();
		addAddress.newPickupAddress("dlf","Test");	
		addAddress.confirmAddress();
		
		String raiseaddress=addAddress.getpickupAddress();
		String raiseaddressContent=addAddress.getpickupAddressContent();
		
		
	//	addAddress.addressTags();
				
		raisecontribution.moneyacceptance();
		String paymentname=raisecontribution.getPaymentName();
		
		
		raisecontribution.confirmPickupButton();
		raisecontribution.checkoutEcoStoreButton();
		Thread.sleep(3000);
		vieworderdetails = new viewOrderDetailsPage(driver);		
		vieworderdetails.homePage();
		cancelPickupOrder=new CancelPickupOrderPage(driver);
		cancelPickupOrder.viewOrderDetailsLink();		
		String time2=vieworderdetails.timeVerification();			 
		 if(time1.equals(time2)) {
			 System.out.println("time matched");
		 }
		 else {
			 System.out.println("time is not matching");
		 }
		 		 
		 String instructionDetails=vieworderdetails.instructionVerification();
		 if(instruction.equalsIgnoreCase(instructionDetails)) {
			 System.out.println("Instrution matched");
		 }else {
			 System.out.println("instructions not matching");
		 }
		 
		 
//		 String addressDetails=vieworderdetails.addressDetailsVerification();
//		 if(raiseaddressContent.equals(addressDetails)) {
//			 System.out.println("address matched");
//		 }
//		 else {
//			 System.out.println("address doesnot matched");
//		 }
//		 
//		 String paymentDetails=vieworderdetails.PaymodeVerification();
//		 if(paymentname.equals(paymentDetails)) {
//			 System.out.println("payment matched");
//		 }
//		 else {
//			 System.out.println("payment doesnot matched");
//		 }
//		 		 		 
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8791555551", "1234"}};
	}
}
