package org.ecocrewFramework;

import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.CancelPickupOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;


public class EditCancelOneTimeOrderTest extends BaseTest {

	NewUserLoginPage loginPage;
	CancelPickupOrderPage cancelPickupOrder;
	B2BOrderPage b2borderPage;
	
	
	@BeforeMethod
	public void preSetup()
	{
		//adb shell dumpsys window | find "mCurrentFocus" ->for windows

		//screen to home page
		Activity activity = new Activity("com.ecocrew.app.sit", "com.ecocrew.app.MainActivity");
		driver.startActivity(activity);	
	}
	
	@Test(dataProvider="getData",priority = 1)
	public void updateOrder(String MobileNumber,String otp) throws InterruptedException {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		b2borderPage=new B2BOrderPage(driver);
		
		b2borderPage.switchProfileLink();
		//cancelPickupOrder.viewOrderDetailsLink();
		b2borderPage.viewBusinessOrderDetails();
		b2borderPage.editPickupButton();
		
		b2borderPage.editPayment();
		b2borderPage.confirm();
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"7142425093" , "1234"} };
	}
	
	
	
	@Test(priority = 2)
	public void CancelOrder() {
//		loginPage=new NewUserLoginPage(driver);
//		loginPage.welcomeScreens();
//		loginPage.inputField("7142425093");
//		loginPage.verifyOTP("1234");
		
		b2borderPage=new B2BOrderPage(driver);
		
		b2borderPage.switchProfileLink();
		//cancelPickupOrder.viewOrderDetailsLink();
		b2borderPage.viewBusinessOrderDetails();
		b2borderPage.cancel();
		
		cancelPickupOrder=new CancelPickupOrderPage(driver);
		cancelPickupOrder.reasonForCancellation();
		cancelPickupOrder.submitButton();
	}
	
	
	
	
}
