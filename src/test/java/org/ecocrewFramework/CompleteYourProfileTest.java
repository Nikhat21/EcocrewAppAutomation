package org.ecocrewFramework;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompleteYourProfileTest extends BaseTest{
	
	NewUserLoginPage loginPage;
	ProfilePage profilepage;
	
	@Test(dataProvider="getData")

	public void completeProfile(String mobileNumber,String OTP) throws InterruptedException {
		loginPage= new NewUserLoginPage(driver);		
		loginPage.welcomeScreens();		
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);
		//loginPage.surveyScreen();

		profilepage=new ProfilePage(driver);
		profilepage.completeProfileHome();
		Thread.sleep(2000);
		String verifyMobileNumber=profilepage.verifyEditMobNumber(mobileNumber);
		Assert.assertEquals(verifyMobileNumber,mobileNumber);
		System.out.println("editMobileNumber :" + verifyMobileNumber);
		profilepage.updateProfile("user","user@gmail.com");
		profilepage.saveChangesProfile();
		profilepage.closePopup();
		
		String ecocoinsText=profilepage.verfiyfiftyecocoins();
		Assert.assertEquals(ecocoinsText,"50");
		System.out.println("ecocoinsText" +ecocoinsText);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8198123907", "1234"}};
   }
	
}
