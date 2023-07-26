package org.ecocrewFramework.admin;

import org.ecocrew.pageobject.admin.android.RegisterYourBusinessActivePage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RegisterYourBusinessPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterYourBusinessAdminTest extends BaseTest{
	NewUserLoginPage loginPage;
	RegisterYourBusinessActivePage registerBusiness;
	RegisterYourBusinessPage registerbusinesspage;
	
	@Test(dataProvider="getData")
	public void registerBusinessActive(String MobileNumber,String otp) {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		
		registerBusiness=new RegisterYourBusinessActivePage(driver);
		registerBusiness.viewLink();
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8282828282" , "1234"} };
	}
	
}
