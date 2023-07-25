package org.ecocrewFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.EditAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.ecocrew.pageobject.android.RaiseContributionRequestPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.openqa.selenium.By;

public class EditAddressTest extends BaseTest{
	NewUserLoginPage loginPage;
	RaisePickupRequestPage raiseRequest;
	RaiseContributionRequestPage raisecontribution;
	EditAddressPage editaddress;
	AddAddressPage addAddress;
	
	@Test(dataProvider="getData")
	public void EditAddressHome(String mobileNumber,String OTP) throws InterruptedException  
	{
		loginPage= new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);
		raiseRequest=new RaisePickupRequestPage(driver);		
		raiseRequest.createOrder();
		raiseRequest.openCameraNewUser();
		
		addAddress = new AddAddressPage(driver);
		//addAddress.pickupAddresss();
		
		editaddress=new EditAddressPage(driver);
		editaddress.addressChange();

		editaddress.editAdd("Work");
		Thread.sleep(2000);
		editaddress.pickAddressUpdate();
		editaddress.landmarkField("Reliance mart");	
		//addAddress.useSavedAddress();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8197125150", "1234"}};
	}
	
//	@DataProvider
//	public Object[][] getData() throws IOException
//	{
//		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//existinguser.json");
//	    return new Object[][] { {data.get(0)},{data.get(1)}  };
//	}
//	
}
