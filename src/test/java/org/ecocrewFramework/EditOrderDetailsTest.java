package org.ecocrewFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.CancelPickupOrderPage;
import org.ecocrew.pageobject.android.EditOrderDetailsPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditOrderDetailsTest extends BaseTest{
	NewUserLoginPage loginPage;
	CancelPickupOrderPage cancelPickupOrder;
	EditOrderDetailsPage editOrderDetails;
	
	
	@Test(dataProvider="getData" ,groups= {"Smoke"})
	public void CancelPickupOrder(HashMap<String,String> input) throws InterruptedException {
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(input.get("mobileNumber"));
		loginPage.verifyOTP(input.get("OTP"));
		
		cancelPickupOrder=new CancelPickupOrderPage(driver);
		cancelPickupOrder.viewOrderDetailsLink();
		
		editOrderDetails= new EditOrderDetailsPage(driver);
		editOrderDetails.editPickupOrder();
		editOrderDetails.popupProceedBtn();
		editOrderDetails.editPickupDate();
		editOrderDetails.editDate();
		editOrderDetails.Selecttimeslot();
		editOrderDetails.pickTimeSlot();
		editOrderDetails.enterInstruction();
		editOrderDetails.contiune();
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//existinguser.json");
	    return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
	
	
	
}
