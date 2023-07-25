package org.ecocrewFramework;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.ecocrewFramework.BaseTest;
import io.appium.java_client.android.Activity;



public class ErrorValidationTest extends BaseTest {
	
	NewUserLoginPage loginPage;
	ProfilePage profilepage;
	
	@BeforeMethod
	public void preSetup()
	{
		//adb shell dumpsys window | find "mCurrentFocus" ->for windows

		//screen to home page
		Activity activity = new Activity("com.ecocrew.app.sit", "com.ecocrew.app.MainActivity");
		driver.startActivity(activity);	
	}
	
	@Test(dataProvider="getData" ,groups= {"Smoke"})
	public void loginErrorValidation(String MobileNumber ) {
		// String MobileNumber = "81971250";

		loginPage = new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
	
		loginPage.inputField(MobileNumber);
		Assert.assertEquals("Invalid phone number", loginPage.getErrorMessage());
}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] { {"8197120"}};
	}
	 
	 @Test
	 public void otpErrorValidation() throws InterruptedException {
		 Thread.sleep(2000);
		 String mobileNumber = "8197125150";
		 String verifyOTP="";
		 loginPage = new NewUserLoginPage(driver);
		// lp.welcomeScreen1();
		//	lp.welcomeScreen2();
		//	lp.welcomeScreen3();
		//	lp.welcomeScreen4();
		 loginPage.inputField(mobileNumber);
		 loginPage.verifyOTP(verifyOTP);
		 Assert.assertEquals("The OTP you entered is incorrect", loginPage.getOTPErrorMessage());
	 }
	 
	 
	 @Test
	 public void profileScreenValidation() throws InterruptedException {
		 Thread.sleep(2000);
		 String mobileNumber = "8197125150";
		 String verifyOTP="1234";
		 loginPage = new NewUserLoginPage(driver);
		 loginPage.inputField(mobileNumber);
		 loginPage.verifyOTP(verifyOTP);
		//loginPage.surveyScreen();
		 Thread.sleep(2000);
         profilepage=new ProfilePage(driver);
		 profilepage.bottomTabProfile();
		 profilepage.personalInfo();
		 profilepage.updateProfile("12","user2@gmail.com");
		 profilepage.saveChangesProfile();
		Assert.assertEquals("Please enter valid name", profilepage.getFullnameErrorMessage());
	 }
	 
//	 @Test
//	 public void completeYourProfileValidation() throws InterruptedException {
//		 Thread.sleep(2000);
//		 String mobileNumber = "8197125150";
//		 String verifyOTP="1234";
//		 loginPage = new NewUserLoginPage(driver);
//		 loginPage.inputField(mobileNumber);
//		 loginPage.verifyOTP(verifyOTP);
//		//loginPage.surveyScreen();
//		 Thread.sleep(2000);
//         profilepage=new ProfilePage(driver);
//         profilepage.completeProfileHome();	
//		 profilepage.updateProfile("user","user2@g");
//		 profilepage.saveChangesProfile();
//		Assert.assertEquals("Please enter valid name", profilepage.getFullnameErrorMessage());
//	 }
//	 
		 
}
