package org.ecocrewFramework;

import java.time.LocalDate;

import org.ecocrew.pageobject.android.B2BOrderPage;
import org.ecocrew.pageobject.android.B2BRecurringOrderPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class B2BOrderRecurringTest extends BaseTest{
	NewUserLoginPage loginPage;
	B2BOrderPage b2border;
	B2BRecurringOrderPage b2bRecurringOrder;
	
	String businessorderPlacedMsg="Recurring pickup request placed \n successfully!!";
	
	
	@Test(dataProvider="getData")
	public void b2bRecurringOrder(String MobileNumber,String otp,String repeat,String payment) throws InterruptedException {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		
		
		b2border=new B2BOrderPage(driver);
		b2border.switchProfileLink();
		b2border.b2bOrder();
		
		b2bRecurringOrder=new B2BRecurringOrderPage(driver);
		b2bRecurringOrder.recurringOrder();
		String userSelectedDate=b2bRecurringOrder.StartsOn();
		
		b2bRecurringOrder.repeatEvery(repeat);
		String userSelectedTime=b2bRecurringOrder.selectTimeSlot();
		Thread.sleep(2000);
		System.out.println(payment);
		String userSelectedPayment=b2bRecurringOrder.moneyMode(payment);
		
		b2bRecurringOrder.confirm();
		 
		String requestPlacedMessage=b2bRecurringOrder.successMessage();
		Assert.assertEquals(requestPlacedMessage, businessorderPlacedMsg);
		 
		 
		b2bRecurringOrder.backToHome();
		 
	    String pickupDetailDate=b2bRecurringOrder.recurringPickupDetails();
		Assert.assertTrue(pickupDetailDate.equalsIgnoreCase(userSelectedDate));
		 
		 
		String pickupDetailTime=b2bRecurringOrder.pickupdetailTime();
		Assert.assertTrue(pickupDetailTime.equalsIgnoreCase(userSelectedTime));
		 
		 
		System.out.println("Details" +pickupDetailTime);
		System.out.println("user" +userSelectedTime);
		 
		 
		String pickupDetailPayment=b2bRecurringOrder.pickupdetailpaymentMode();
		 
		Assert.assertTrue(pickupDetailPayment.equalsIgnoreCase(userSelectedPayment));
				
		b2bRecurringOrder.cancelBusinessOrder();
		

	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"7142425093" , "1234" , "Everyday" , "Cash"} };
	}
	
	//Everyday,Every 2nd day,Weekly on Saturday and Tuesday,Weekly on Saturday,Once in 2 weeks
	
}
