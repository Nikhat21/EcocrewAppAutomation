package org.ecocrew.pageobject.android;

import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewUserLoginPage extends AndroidAction{
	
	public  AndroidDriver driver;
	public NewUserLoginPage(AndroidDriver driver) {
        super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.walk1']")
    WebElement ecocrew_walk1;
    
   
   @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.walk2']")
   private WebElement ecocrew_walk2;

   @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.walk3']")
   private WebElement ecocrew_walk3;

   @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.walk4']")
   private WebElement ecocrew_walk4;
  
   @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.loginMobileInput']")
   private WebElement  mobileNoInput;

   @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.loginButton']")
   private WebElement  loginButton;

   
   @AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid phone number']")
   private WebElement  invalidNoMessage;
   
   @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.otpInput']")
   private WebElement verifyOTPText;

   
   @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.confirmOtpButton']")
   private WebElement verifyButton;
   
   @AndroidFindBy(xpath = "//android.widget.TextView[@text='The OTP you entered is incorrect']")
   private WebElement  invalidOTPMessage;
   
   @AndroidFindBy(xpath = "(//android.widget.RadioButton[@content-desc='ecocrew.surveyRadioButton'])")
   List<WebElement>  websiteRadioButton;
   
   @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.surveySubmitButton']")
   private WebElement  surveySubmitButton;
   
   

   
   public void welcomeScreens() {
		ecocrew_walk1.click();
		ecocrew_walk2.click();
		ecocrew_walk3.click();
		ecocrew_walk4.click();
	}
   


   
   public void inputField(String mobNo) {
	    mobileNoInput.sendKeys(mobNo);
	     loginButton.click();
	   }
   
   public String getErrorMessage() {
	     String invalidNumber = invalidNoMessage.getText();
	     return invalidNumber;

   }
   
   public String getOTPErrorMessage() {
	   String otpInvalidMessage=invalidOTPMessage.getText();
	   return otpInvalidMessage;
	   
   }
   
	  
   public void verifyOTP(String otp) {
	   verifyOTPText.sendKeys(otp);
	   scrollToText("Verify");
	   verifyButton.click();
   }
	    
public  void setActivity() {
	   System.out.println("Inside setActivity");
	Activity activity = new Activity("com.ecocrew.app.sit","com.ecocrew.app.MainActivity");
	System.out.println("activity===" +activity);
	driver.startActivity(activity);

	
	
	
   }
   
   public void surveyScreen() {
	   websiteRadioButton.get(0).click();
	   surveySubmitButton.click();
   }

}



