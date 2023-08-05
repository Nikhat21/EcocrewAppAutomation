package org.ecocrewFramework;

import java.time.Duration;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.CancelPickupOrderPage;
import org.ecocrew.pageobject.android.EditAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.ecocrew.pageobject.android.viewOrderDetailsPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RaisePickupRequestExistingUser extends BaseTest{
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	RaiseContributionRequestPage raisecontribution;
	CancelPickupOrderPage cancelPickupOrder;
	viewOrderDetailsPage vieworderdetails;
	 AddAddressPage addAddress;
	 EditAddressPage editaddress;
	 
	 @Test(dataProvider="getData" , groups= {"Smoke"},priority = 1)
		public void pickupRequestExistingUser(String mobileNumber,String OTP) throws InterruptedException {
			loginPage= new NewUserLoginPage(driver);
		  	loginPage.welcomeScreens();	
			loginPage.inputField(mobileNumber);
			loginPage.verifyOTP(OTP);	
			Thread.sleep(2000);
					
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='ecocrew.FirstPickupRequestRaisePickup']/android.widget.TextView")),"text" , "Raise pickup request"));
			raiseRequest=new RaisePickupRequestPage(driver);		
			raiseRequest.createOrder();
			
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
			 
			 cancelPickupOrder.cancelPickupOrder();
				//cancelPickupOrder.cancelViewOnButton();
				cancelPickupOrder.reasonForCancellation();
				cancelPickupOrder.submitButton();
			 
			 
		}
		
		@DataProvider
		public Object[][] getData(){
			return new Object[][] { {"3313313271", "1234"}};
		}
		
		
		
		@Test(priority = 2)
		public void changeAddressExistingUser( ) throws InterruptedException {	
		
					
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='ecocrew.FirstPickupRequestRaisePickup']/android.widget.TextView")),"text" , "Raise pickup request"));
			raiseRequest=new RaisePickupRequestPage(driver);		
			raiseRequest.createOrder();
			Thread.sleep(2000);
			raiseRequest.mobCamerauser();
			raisecontribution=new RaiseContributionRequestPage(driver);	
			Thread.sleep(3000);
			String raisecontributionHeading=raisecontribution.getHeading();
			Assert.assertEquals(raisecontributionHeading,"RAISE A CONTRIBUTION REQUEST");
			raisecontribution.selectRandomDate();
			//raisecontribution.getDate();
			raisecontribution.selectTime();
			raisecontribution.SelectTimeSlot();
			String time1=raisecontribution.getTime();
			 
			editaddress=new EditAddressPage(driver);
			editaddress.addressChange();
			Thread.sleep(2000);
			editaddress.addNewAddressLink();
			addAddress=new AddAddressPage(driver);
			
			addAddress.newPickupAddress("dlf", "PlotNo 32");
			addAddress.addressTabsClick("Work");
			addAddress.confirmAddress();
			addAddress.getSavedTabLabel("Work");
			Thread.sleep(2000);
			raisecontribution.moneyacceptance();
	 		String paymentname=raisecontribution.getPaymentName();
	         	         
			raisecontribution.confirmPickupButton();
			raisecontribution.checkoutEcoStoreButton();
			
		}
}
