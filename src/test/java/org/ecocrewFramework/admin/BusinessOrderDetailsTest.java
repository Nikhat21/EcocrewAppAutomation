package org.ecocrewFramework.admin;

import org.ecocrew.pageobject.admin.android.RegisterYourBusinessActivePage;
import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.B2BRecurringOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.Test;

public class BusinessOrderDetailsTest extends BaseTest {
	NewUserLoginPage loginPage;
	B2BOrderPage b2borderpage;
	B2BRecurringOrderPage b2brecurringorderpage;
	RegisterYourBusinessActivePage active;
	@Test
	public void businessEveryDayVerification() {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField("6792828248");
		loginPage.verifyOTP("1234");
		
		
		b2borderpage=new B2BOrderPage(driver);
		b2borderpage.switchProfileLink();

		b2borderpage.viewBusinessOrderDetails();
		
		
		b2brecurringorderpage=new B2BRecurringOrderPage(driver);
		String date=b2brecurringorderpage.recurringPickupDetails();
		System.out.println(date);
		
		active=new RegisterYourBusinessActivePage(driver);
		active.executiveName();
		active.executiveNumber();
		
	
		
		
		
		
		
	}
}
