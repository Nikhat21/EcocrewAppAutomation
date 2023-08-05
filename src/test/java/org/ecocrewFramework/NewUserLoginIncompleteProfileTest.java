package org.ecocrewFramework;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.ecocrewFramework.TestUtils.BaseTest;
import org.openqa.selenium.By;

public class NewUserLoginIncompleteProfileTest extends BaseTest {
	NewUserLoginPage loginPage;	
	
	@Test(dataProvider="getDataInCompleteProfile")
	public void loginInCompleteProfile(HashMap<String,String> input) throws InterruptedException  {
		Thread.sleep(2000);
		loginPage= new NewUserLoginPage(driver);		
		loginPage.welcomeScreens();		
		loginPage.inputField(input.get("mobileNumber"));
		loginPage.verifyOTP(input.get("OTP"));
		loginPage.surveyScreen();
		ProfilePage profilepage=new ProfilePage(driver);
		profilepage.bottomTabProfile();
		profilepage.personalInfo();
		String verifyMobileNumber=profilepage.verifyEditMobNumber(input.get("mobileNumber"));
		Assert.assertEquals(input.get("mobileNumber"),verifyMobileNumber);
		System.out.println("editMobileNumber :" + verifyMobileNumber);
		profilepage.updateIncompelteProfile("user","user@gmail.com");
		profilepage.saveChangesProfile();
//		profilepage.closePopup();
		profilepage.bottomTabhome();
		profilepage.bottomTabProfile();
		String ecocoinsText=profilepage.verfiyfiftyecocoins();
		Assert.assertEquals(ecocoinsText,"0");
		System.out.println("ecocoinsText" +ecocoinsText);
							
//		String otpVerified = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//       System.out.println(otpVerified);
//       Assert.assertEquals(otpVerified, "OTP Verified! Your OTP is verified successfully");				
	}
	@DataProvider
	public Object[][] getDataInCompleteProfile() throws IOException
	{
		List<HashMap<String, String>> data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//newuserincompleteprofile.json");	
		System.out.println("data.get(0)="+data.get(0));
		System.out.println("data.get(1)="+data.get(1));
		return new Object[][] { {data.get(0)},{data.get(1)}  };
	}

}
