package org.ecocrew.pageobject.android;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends AndroidAction{
	AndroidDriver driver;
	public ProfilePage(AndroidDriver driver) {
        super(driver);

		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='ecocrew.mainBottomTabBarHome']/android.view.ViewGroup")
	private WebElement homeBottomTab;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='ecocrew.mainBottomTabBarAccount']")
	private WebElement userProfile;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal information']")
	private WebElement personalInformation;
	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc='ecocrew.fullnameEditProfile']")
	private WebElement fullNameField;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.emailEditProfile']")
	private WebElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc='ecocrew.mobileEditProfile']")
	private WebElement mobileNumberField;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='ecocrew.saveChangesButtonEditProfile']")
	private WebElement saveChangesButton;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.gobackButtonEditProfile']")
	private WebElement discardButton;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.coinsAddedButtonEditProfile']")
	private WebElement closeButton;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.editButtonEditProfile']")
	private WebElement profilePicture;

	@AndroidFindBy(xpath="	//android.view.ViewGroup[@content-desc='ecocrew.selectingCameraEditProfile']")
	private WebElement selectCamera;
	
	@AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement whileUsingTheApp;


	
  @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Shutter']")
	private WebElement cameraIcon;

  
  @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Done']")
	private WebElement doneIcon;
  
  
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter valid name']")
  private WebElement  invalidFullName;

  
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='My eco-coins']")
  private WebElement  Myecocoins;
  
  //Complete your profile
  
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.ProfileUpdateEcoCoinsCompleteProfile']")
    WebElement CompleteProfile;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.EcoCoinViewGoToLedger']/android.widget.TextView")
	WebElement fiftyEcocoinsText;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraLaunchCameraButton']")
	WebElement mobilecamera;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='ecocrew.CustomCameraSubmitButton']")
	WebElement mobilecameraDone;
	
	
	@AndroidFindBy(id = "com.sec.android.app.camera:id/bottom_background")
	WebElement mobCamera;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='OK']")
	WebElement mobCameraok;
	
	//android.widget.Button[@content-desc="OK"]
	
	//android.view.ViewGroup[@content-desc="ecocrew.CustomCameraLaunchCameraButton"]

	
	public void bottomTabhome() {
		homeBottomTab.click();
	}
	
	
	public void bottomTabProfile() {
		userProfile.click();
	}
	
	public void personalInfo() {
		
			personalInformation.click();
				
	}
	
	public String verifyEditMobNumber(String mobileNumber) {
		String verifyMobileNumber=mobileNumberField.getText();
        return verifyMobileNumber; 

	}
	
	public void updateProfile(String fullName,String email) throws InterruptedException {
		profilePicture.click();
		selectCamera.click();
		whileUsingTheApp.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
		mobCameraok.click();
		Thread.sleep(2000);
		//cameraIcon.click();
		//doneIcon.click();
		fullNameField.clear();
		fullNameField.sendKeys(fullName);
		emailField.clear();
		emailField.sendKeys(email);
		scrollToText("Save changes");
       
		
	}
	
	
	public void updateIncompelteProfile(String fullName,String email) {
		fullNameField.clear();
		fullNameField.sendKeys(fullName);
		emailField.clear();
		emailField.sendKeys(email);
		scrollToText("Save changes");
        
	}
	
	public void saveChangesProfile()
	{
		saveChangesButton.click();
	}
	
	 public void discardProfile() {
		   discardButton.click();
		   }
	
	
	
	public void closePopup() {
		closeButton.click();
	}
	
	   public String getFullnameErrorMessage() {
		     String fullnameErrormessage = invalidFullName.getText();
		     return fullnameErrormessage;

	   }
	   
	   public String verifymyecopoints() {
		  return Myecocoins.getText();
	   }
	   
	   public void completeProfileHome() {
		   CompleteProfile.click();
	   }
	   public String verfiyfiftyecocoins() {
		   String ecocoins=fiftyEcocoinsText.getText();
		   System.out.println(ecocoins);
		   return ecocoins;
		   
	   }
	   
	   
	  

}
