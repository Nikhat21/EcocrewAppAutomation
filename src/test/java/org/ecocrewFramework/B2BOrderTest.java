package org.ecocrewFramework;

import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class B2BOrderTest extends BaseTest{

	NewUserLoginPage loginPage;
	B2BOrderPage b2border;
	
	@Test(dataProvider="getData")
	public void b2bPickupRequest(String MobileNumber,String otp) {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		b2border=new B2BOrderPage(driver);
		b2border.viewLink();
		b2border.switchProfileLink();
		b2border.b2bOrder();
		b2border.oneTime();
		b2border.selectDate();
		b2border.selectTimeSlot();
		b2border.moneyAcceptanceMode();
		b2border.confirm();
		b2border.backToHome();		
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8282828248" , "1234"} };
	}
	
}
