package org.ecocrewFramework;

import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.B2BRecurringOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class B2BRecurringValidationTest extends BaseTest {
	NewUserLoginPage loginPage;	
	B2BRecurringOrderPage b2bRecurringOrder;
	B2BOrderPage b2border;
	String expectedDate = "Please select date";
	String repeastErrorMsg= "Please select Repeats every";
	String timeErrorMsg = "Please select time";
	

	@Test(dataProvider="getData")
	public void b2bRecurringErrors(String MobileNumber,String otp) throws InterruptedException {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		
		b2border=new B2BOrderPage(driver);
		b2border.switchProfileLink();
		b2border.b2bOrder();
		
		b2bRecurringOrder=new B2BRecurringOrderPage(driver);
		b2bRecurringOrder.recurringOrder();
		
		b2bRecurringOrder.confirm();
		Assert.assertEquals(b2bRecurringOrder.getStartOnErrorMessage(),expectedDate);


		driver.navigate().back();
		b2border.b2bOrder();

		b2bRecurringOrder.recurringOrder();
		b2bRecurringOrder.StartsOn();
		b2bRecurringOrder.confirm();
		Assert.assertEquals(b2bRecurringOrder.getRepeatsEveryMessage(),repeastErrorMsg);

			
		driver.navigate().back();
		b2border.b2bOrder();

		b2bRecurringOrder.recurringOrder();
		b2bRecurringOrder.StartsOn();
        b2bRecurringOrder.repeatEvery("Everyday");
		b2bRecurringOrder.confirm();
		Assert.assertEquals(b2bRecurringOrder.getTimeErrorMessage(),timeErrorMsg);

	}
	
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"7142425093" , "1234"} };
	}
}
