package org.ecocrewFramework.admin;

import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.Test;

public class BusinessOrderDetailsTest extends BaseTest {
	NewUserLoginPage loginPage;
	B2BOrderPage b2borderpage;
	
	
	@Test(dataProvider="getData")
	public void businessEveryDayVerification(String MobileNumber,String otp) {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		
		b2borderpage=new B2BOrderPage(driver);
		b2borderpage.switchProfileLink();
		b2borderpage.viewBusinessOrderDetails();
		
		
		
		
		
	}
}
