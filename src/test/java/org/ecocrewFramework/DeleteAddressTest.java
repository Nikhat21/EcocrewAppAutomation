package org.ecocrewFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.AddAddressPage;
import org.ecocrew.pageobject.android.DeleteAddressPage;
import org.ecocrew.pageobject.android.EditAddressPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RaisePickupRequestPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class DeleteAddressTest extends BaseTest{
	AddAddressPage addAddress;
	DeleteAddressPage deleteAddress;
	NewUserLoginPage  loginPage;
	RaisePickupRequestPage raiseRequest;
	EditAddressPage editaddress;

	
	
	
	
	@Test(dataProvider="getData")
	public void deleteAddress(String mobileNumber,String OTP) throws InterruptedException {
	    loginPage= new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);
		raiseRequest=new RaisePickupRequestPage(driver);		
		raiseRequest.createOrder();
		raiseRequest.openCameraNewUser();
		
		
		editaddress=new EditAddressPage(driver);
		editaddress.addressChange();

		addAddress = new AddAddressPage(driver);
		//addAddress.pickupAddresss();
		
		deleteAddress=new DeleteAddressPage(driver);
		deleteAddress.deleteButton("Work");
		deleteAddress.confirmDelete();	
		
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
}
