package org.ecocrewFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.AccountSettingPage;
import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.ecocrew.pageobject.android.RegisterYourBusinessPage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountSettingTest extends BaseTest {
	AccountSettingPage accountSettingPage;
	NewUserLoginPage loginPage;
	ProfilePage profilepage;
	RegisterYourBusinessPage registerbusiness;
	
	@Test(dataProvider="getData")
	public void accountSetting(HashMap<String,String> input) throws InterruptedException {
		
		loginPage=new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(input.get("mobileNumber"));
		loginPage.verifyOTP(input.get("OTP"));
		//loginPage.surveyScreen();
		profilepage=new ProfilePage(driver);
		profilepage.bottomTabProfile();
				
		accountSettingPage=new AccountSettingPage(driver);
		accountSettingPage.myOrdersMenu();
		String expectedText="My Contribution";
		Assert.assertEquals(accountSettingPage.myContributionTab(), expectedText);
		
//		String expectedOngoing="ONGOING";
//		Assert.assertEquals(accountSettingPage.onGoingButton(),expectedOngoing);
//		
//		String expectedpickUpstatus="Placed";
//		Assert.assertEquals(accountSettingPage.pickUpStatus(), expectedpickUpstatus);	
//		
//		String cancelledpickUpstatus="CANCELLED";
//		Assert.assertEquals(accountSettingPage.cancelledButton(), cancelledpickUpstatus);
		
		driver.navigate().back();
		accountSettingPage.SavedaddressesMenu();
		
		String savedAddressesPagestatus="SAVED ADDRESSES";
		Assert.assertEquals(accountSettingPage.savedAddressesPage(), savedAddressesPagestatus);
		
		driver.navigate().back();
		
		accountSettingPage.myreferralsMenu();
		accountSettingPage.shareLinkTab();
		accountSettingPage.myReferralsTab();
		
		driver.navigate().back();		
		accountSettingPage.registerAsABusiness();
		
		
		registerbusiness=new RegisterYourBusinessPage(driver);		
		registerbusiness.RegisterNowClick();
		registerbusiness.enterBusinessName("Whole Grains");
		registerbusiness.enterGST("12444ADFBFFF");
		registerbusiness.uploadImages();
		registerbusiness.businessLocation();
		registerbusiness.search();
		registerbusiness.businessAddress();
		registerbusiness.confirm();
		String thankyoumesssage=registerbusiness.getThankyouText();
		System.out.println("thankyoumesssage " +thankyoumesssage);
		Assert.assertEquals(thankyoumesssage, "Thank you for your submission!");
		registerbusiness.backToProfile();
		String reviewmessage=registerbusiness.reviewMessage();
		System.out.println("reviewmessage " +reviewmessage);
		Assert.assertEquals(reviewmessage, "Your business profile is in review");
//		driver.navigate().back();	
//		accountSettingPage.scroll();
//		accountSettingPage.logoutUser();
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//accountsetting.json");
	    return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
}
