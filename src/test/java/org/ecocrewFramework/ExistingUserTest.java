package org.ecocrewFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.ecocrew.pageobject.android.NewUserLoginPage;
import org.ecocrew.pageobject.android.ProfilePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExistingUserTest extends BaseTest {
NewUserLoginPage loginPage;
	
	@Test(dataProvider="getData")
	public void login(HashMap<String,String> input) throws InterruptedException  {
		Thread.sleep(2000);		
		loginPage= new NewUserLoginPage(driver);
		loginPage.welcomeScreens();
		loginPage.inputField(input.get("mobileNumber"));
		loginPage.verifyOTP(input.get("OTP"));
		ProfilePage profilepage=new ProfilePage(driver);
		profilepage.bottomTabProfile();
		profilepage.personalInfo();
		String verifyMobileNumber=profilepage.verifyEditMobNumber(input.get("mobileNumber"));
		Assert.assertEquals(input.get("mobileNumber"),verifyMobileNumber);
		System.out.println("editMobileNumber :" + verifyMobileNumber);
		profilepage.updateProfile("userrr","userrr@gmail.com");
		String ecopoints=profilepage.verifymyecopoints();
		Assert.assertEquals("My eco-coins", ecopoints);
					
//		String otpVerified = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//       System.out.println(otpVerified);
//       Assert.assertEquals(otpVerified, "OTP Verified! Your OTP is verified successfully");				
	}
	
	@BeforeMethod(alwaysRun=true)
	public void preSetUp() throws InterruptedException
	{
      loginPage.setActivity(); 
	}
	
//	@DataProvider
//	public Object[][] getData(){
//		return new Object[][] { {"8197125150", "1234"}};
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//ecocrewFramework//testdata//existinguser.json");
	    return new Object[][] { {data.get(0)},{data.get(1)}  };
	}

	
	
	
}
