package org.ecocrew.pageobject.android;

import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditAddressPage extends AddAddressPage{
	AndroidDriver driver;
	//AddAddressPage addaddres;
	
	public EditAddressPage(AndroidDriver driver) {
       super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupChangeAddress']")
	private WebElement OneTimePickupChangeAddress;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement whileusingtheapp;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddPickupAddressEnterCompleteAddress']")
	private WebElement enterCompleteAddress;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.editAddressOnMyAddress']")
	List<WebElement> editAddressOnMyAddress;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddPickupAddressRoadAddressInput']")
	private WebElement landmark;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddPickupAddressSubmitAddress']")
	private WebElement confirm;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.usingAddressOnMyAddress']")
	private WebElement useThis;
	
	@AndroidFindBy(xpath = "((//android.view.ViewGroup[@content-desc='ecocrew.AddPickupAddressAddressTag'])/android.widget.TextView")
	List<WebElement> pickupAddressAddressTag;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.addNewAddressOnMyAddress']")
	private WebElement addNewAddress;
	
	public void pickAddressUpdate() {	
		whileusingtheapp.click();
		enterCompleteAddress.click();
	}
	
	public void addressChange() {
		OneTimePickupChangeAddress.click();
	}
	
	public void editAdd(String tabs) throws InterruptedException {
		//addaddres=new AddAddressPage(driver);
		//MyAddressScreenAddressLabelText.size();
		
	   String label =null;
  	  System.out.println(MyAddressScreenAddressLabelText.size());
  	  for(int i=0;i<MyAddressScreenAddressLabelText.size();i++)
  	  {
      	  label=MyAddressScreenAddressLabelText.get(i).getText();
      	  System.out.println("label " +label);
      	  System.out.println("tabs " +tabs);
      	  Thread.sleep(3000);
      	  if(label.equals(tabs)) {
      		  Thread.sleep(3000);
      		editAddressOnMyAddress.get(i).click();
      		  
      	  }
      	 
  	  }
	}
	
//	public void EditAddress() {
//		editAddressOnMyAddress.click();
//		whileusingtheapp.click();		
//	}
	
	public void landmarkField(String landMark) {   
		scrollToText("Confirm");
		landmark.sendKeys(landMark);
		confirm.click();
	}
	
	
	public void addNewAddressLink() {
		addNewAddress.click();
	}
	
	
//	public void addressTags() {
//		for(WebElement tags : pickupAddressAddressTag) {
//			String pickupAddressTags=tags.getText();
//			System.out.println(pickupAddressTags);
//		
//			if(pickupAddressTags.equalsIgnoreCase("Home")) {
//				landmarkField(landMark);
//			}
//			
//			
//		}
		

	
}
