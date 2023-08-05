package org.ecocrewFramework;

import org.ecocrew.pageobject.android.CancelPickupOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;
import org.ecocrew.pageobject.android.viewOrderDetailsPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ViewOrderDetailsTest extends BaseTest{
	
	NewUserLoginPage loginPage;
	viewOrderDetailsPage vieworderdetails;
	CancelPickupOrderPage cancelPickupOrder;
	RaiseContributionRequestPage raisecontribution;
	
	
	@Test(dataProvider="getData")
	public void veiwOrderDetailsVerification(String mobileNumber,String OTP) throws InterruptedException {
		
		loginPage= new NewUserLoginPage(driver);
	  	loginPage.welcomeScreens();	
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);
		
		cancelPickupOrder=new CancelPickupOrderPage(driver);
		cancelPickupOrder.viewOrderDetailsLink();
		
		
		vieworderdetails = new viewOrderDetailsPage(driver);
		
		
		vieworderdetails.homePage();
		String time1=vieworderdetails.timeVerification();
		
		 raisecontribution=new RaiseContributionRequestPage(driver);
		 
		 String time2=raisecontribution.getTime();
		 
		 if(time1.equals(time2)) {
			 System.out.println("time matched");
		 }
		 else {
			 System.out.println("time is not matching");
		 }		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8598999049", "1234"}};
	}
}
