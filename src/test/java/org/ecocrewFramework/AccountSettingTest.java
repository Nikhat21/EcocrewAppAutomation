package org.ecocrewFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.AccountSettingPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountSettingTest extends BaseTest {
	AccountSettingPage accountSettingPage;
	NewUserLoginPage loginPage;
	ProfilePage profilepage;
	
	@Test(dataProvider="getData")
	public void accountSetting(HashMap<String,String> input) {
		
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(input.get("mobileNumber"));
		loginPage.verifyOTP(input.get("OTP"));
				
		profilepage=new ProfilePage(driver);
		profilepage.bottomTabProfile();
				
		accountSettingPage=new AccountSettingPage(driver);
		accountSettingPage.myOrdersMenu();
		String expectedText="My Contribution";
		Assert.assertEquals(accountSettingPage.myContributionTab(), expectedText);
		
		String expectedOngoing="ONGOING";
		Assert.assertEquals(accountSettingPage.onGoingButton(),expectedOngoing);
		
		String expectedpickUpstatus="Placed";
		Assert.assertEquals(accountSettingPage.pickUpStatus(), expectedpickUpstatus);	
		
		String cancelledpickUpstatus="CANCELLED";
		Assert.assertEquals(accountSettingPage.cancelledButton(), cancelledpickUpstatus);
		
		driver.navigate().back();
		accountSettingPage.SavedaddressesMenu();
		
		String savedAddressesPagestatus="SAVED ADDRESSES";
		Assert.assertEquals(accountSettingPage.savedAddressesPage(), savedAddressesPagestatus);
		
		driver.navigate().back();
		
		accountSettingPage.myreferralsMenu();
		accountSettingPage.shareLinkTab();
		accountSettingPage.myReferralsTab();
		
		driver.navigate().back();		
		accountSettingPage.scroll();
		accountSettingPage.logoutUser();
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//accountsetting.json");
	    return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
}
