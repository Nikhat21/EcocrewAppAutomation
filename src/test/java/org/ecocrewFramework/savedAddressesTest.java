package org.ecocrewFramework;
import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.EditAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.ecocrewFramework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class savedAddressesTest extends BaseTest{
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	EditAddressPage editaddress;

	 AddAddressPage addAddress;
	
	@Test(dataProvider="getData")

	public  void useThisAddress(String mobileNumber,String OTP) throws InterruptedException {
		loginPage= new NewUserLoginPage(driver);
	  	loginPage.welcomeScreens();	
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);	
		Thread.sleep(2000);

		raiseRequest=new RaisePickupRequestPage(driver);		
		raiseRequest.createOrder();
		raiseRequest.openCameraNewUser();
        
		Thread.sleep(2000);

		editaddress =new EditAddressPage(driver);
		editaddress.addressChange();
		
		addAddress= new AddAddressPage(driver);
		//addAddress.pickupAddresss();
		String savedTablabel=addAddress.getSavedTabLabel("Work");

		String pickupAddressLabel=addAddress.getpickupAddress();
		Assert.assertEquals(pickupAddressLabel, savedTablabel);
		
		
//		String savedaddressContent=addAddress.getSavedAddressContent();
//		String pickupAddressContent=addAddress.getpickupAddressContent();
//		
//		Assert.assertEquals(pickupAddressContent, savedaddressContent);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8197125150", "1234"}};
	}

	
	
}
