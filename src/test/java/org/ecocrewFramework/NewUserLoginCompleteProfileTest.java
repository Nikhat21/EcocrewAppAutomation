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
import org.ecocrewFramework.TestUtils.BaseTest;
import org.openqa.selenium.By;



public class NewUserLoginCompleteProfileTest extends BaseTest{
	NewUserLoginPage loginPage;		
			
		
	@Test(dataProvider="getDataCompleteProfile",groups= {"Smoke"})
	public void loginCompleteProfile(String MobileNumber,String otp) throws InterruptedException  {
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
		profilepage.updateProfile("user","user@gmail.com");
		profilepage.saveChangesProfile();
		profilepage.closePopup();
		profilepage.bottomTabhome();
		profilepage.bottomTabProfile();
		String ecocoinsText=profilepage.verfiyfiftyecocoins();
		Assert.assertEquals(ecocoinsText,"50");
		System.out.println("ecocoinsText" +ecocoinsText);
							
//		String otpVerified = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//       System.out.println(otpVerified);
//       Assert.assertEquals(otpVerified, "OTP Verified! Your OTP is verified successfully");				
	}
	
//	@BeforeMethod
//	public void preSetUp() throws InterruptedException
//	{
//		//loginPage= new NewUserLoginPage(driver);
//		System.out.println("inside presetup method");
//      loginPage.setActivity(); 
//	}

		
		
	@DataProvider
	public Object[][] getDataCompleteProfile(){
		return new Object[][] { {"4372710122" , "1234"} };
	}
	

	
	
//	@DataProvider
//	public Object[][] getDataCompleteProfile() throws IOException
//	{
//		List<HashMap<String, String>> data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//newuser.json");	
//		System.out.println("data.get(0)="+data.get(0));
//		System.out.println("data.get(1)="+data.get(1));
//		return new Object[][] { {data.get(0)},{data.get(1)}  };
//	}
	
	
	
}
