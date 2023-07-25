package org.ecocrewFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.openqa.selenium.By;

public class DiscardProfileTest extends BaseTest{
	NewUserLoginPage loginPage;		

	@Test(dataProvider="getData")
	public void discardProfile(String MobileNumber,String otp) throws InterruptedException  {
		Thread.sleep(2000);
		loginPage= new NewUserLoginPage(driver);		
		loginPage.welcomeScreens();		
		loginPage.inputField(MobileNumber);
		loginPage.verifyOTP(otp);
		loginPage.surveyScreen();
		ProfilePage profilepage=new ProfilePage(driver);
		profilepage.bottomTabProfile();
		profilepage.personalInfo();
		String verifyMobileNumber=profilepage.verifyEditMobNumber(MobileNumber);
		Assert.assertEquals(MobileNumber,verifyMobileNumber);
		System.out.println("editMobileNumber :" + verifyMobileNumber);
		profilepage.updateProfile("discarduser","discarduser@gmail.com");
		profilepage.discardProfile();
		profilepage.bottomTabhome();
		profilepage.bottomTabProfile();
		String ecocoinsText=profilepage.verfiyfiftyecocoins();
		Assert.assertEquals(ecocoinsText,"0");
		System.out.println("ecocoinsText" +ecocoinsText);
						
	}
		
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"9111111111" , "1234"} };
	}
}
