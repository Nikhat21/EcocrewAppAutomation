package org.ecocrewFramework;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.RegisterYourBusinessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterYourBusinessTest extends BaseTest{
	NewUserLoginPage loginPage;
	RegisterYourBusinessPage registerbusiness;

	@Test(dataProvider="getData",groups= {"Smoke"})

	public void registerYourBusiness(String mobileNumber,String OTP ) throws InterruptedException {
		loginPage= new NewUserLoginPage(driver);
	  	loginPage.welcomeScreens();	
		loginPage.inputField(mobileNumber);
		loginPage.verifyOTP(OTP);	
		loginPage.surveyScreen();
		
		registerbusiness=new RegisterYourBusinessPage(driver);		
		registerbusiness.registerYourBusinessButton();
		registerbusiness.businessDetails();
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
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"7142425293", "1234"}};
	}
	
}
