package org.ecocrew.pageobject.android;
import java.util.List;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddAddressPage extends AndroidAction {
	AndroidDriver driver;

	public AddAddressPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.OneTimePickupSelectAddress']")
	private WebElement pickupAddress;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement address_Whileusingtheapp;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.AddPickupAddressUseSavedAddress'])")
	private WebElement searchPickupAddress;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddPickupAddressSearchKey']")
	private WebElement pickupAddressSearchKey;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AddPickupAddressSearchData']")
	List<WebElement> addPickupAddress;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddPickupAddressEnterCompleteAddress']")
	private WebElement enterCompleteAddress;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ecocrew.AddPickupAddressHouseAddressInput']")
	private WebElement pickupAddressInput;
	
	 
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.OneTimePickupAddressLabel']")
	private WebElement pickupAddressMainLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.OneTimePickupAddressContent']")
	private WebElement pickupAddressContent;


	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.AddPickupAddressSubmitAddress']")
	private WebElement confirm;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AddPickupAddressHouseError']/android.widget.TextView")
	private WebElement addressRequiredError;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='ecocrew.AddPickupAddressSaveAddCheckBox']")
	private WebElement saveAddressCheckbox;
	

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='ecocrew.AddPickupAddressAddressTag']/android.widget.TextView)")
	List<WebElement> addAddressTags;
	
	

	
	//Saved Addresses elements
	
	//Home,Work,Other
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.MyAddressScreenAddressLabelText']")
	List<WebElement> MyAddressScreenAddressLabelText;
	
	//Address Content
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ecocrew.MyAddressScreenAddressContentText']")
	List<WebElement> MyAddressScreenAddressContentText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.usingAddressOnMyAddress']")
	List<WebElement> useThis;

	
	
	
	public void pickupAddresss() {
		pickupAddress.click();
	}

	public void newPickupAddress(String search,String buildingName) throws InterruptedException {
		address_Whileusingtheapp.click();
		searchPickupAddress.click();
		pickupAddressSearchKey.sendKeys(search);
		Thread.sleep(3000);
		addPickupAddress.get(1).click();


		
		enterCompleteAddress.click();
		for(WebElement option : addAddressTags) {
			System.out.println("labels are = " + option.getText());
		}

		pickupAddressInput.sendKeys(buildingName);
	    Boolean defaultcheckbox = saveAddressCheckbox.isSelected();
		System.out.println("sav checkbox:" +defaultcheckbox);
	
		
	}
	
	
	public void confirmAddress() {
		scrollToText("Confirm");
		confirm.click();
	}
	
	
	
	
	public String getAddAddressPickpup() {
		String addAddressErrorMessage = addressRequiredError.getText();
		System.out.println("-----------" +addAddressErrorMessage);
		return addAddressErrorMessage;
	}
	
      public void addressTags() {
		
		for(WebElement option : addAddressTags) {
		System.out.println("labels are = " + option.getText());
		
	}
}
     
      public void addressTabsClick(String tabs) {
    	  String listTabs=null;
    	  for(int i=0;i<addAddressTags.size();i++) {
    		  
    		   listTabs=addAddressTags.get(i).getText();
    		  System.out.println(listTabs);
    	  
    	 if(listTabs.equalsIgnoreCase(tabs)) {
    		 addAddressTags.get(i).click();
    		      	  
    	 }
    	 
    	  }
    	  
      }
      
      
      public String getSavedTabLabel(String tabs) throws InterruptedException {
    	  String label = null;
    	  String addressContent =null;
    	  System.out.println(MyAddressScreenAddressLabelText.size());
    	  for(int i=0;i<MyAddressScreenAddressLabelText.size();i++)
    	  {
        	  label=MyAddressScreenAddressLabelText.get(i).getText();
        	  System.out.println("label " +label);
        	  System.out.println("tabs " +tabs);
        	  Thread.sleep(3000);
        	  if(label.equals(tabs)) {
        		  Thread.sleep(3000);
        		  useThis.get(i).click();
        		  
        	  }
        	 
    	  }
    	 return label;
      }
      
      
      
      
      public String getSavedAddressContent(String tab) throws InterruptedException {
    	 String tabs=getSavedTabLabel(tab);
    	 String addressContent= null;
    	 
    	 if(tabs.equals(addressContent))
      
    	  for(int i=0;i<MyAddressScreenAddressContentText.size();i++)
    	  {
    		  addressContent=MyAddressScreenAddressContentText.get(i).getText();
        	  System.out.println("label " +addressContent);
        	  
        	  
        	  }
    	  return addressContent;
    	  }
    	  
    	  
    	 

    	
    	     
  	public String getpickupAddress() throws InterruptedException {
  		scrollToText("Confirm pickup");
  		Thread.sleep(3000);
		String addressLabel=pickupAddressMainLabel.getText();
		System.out.println("addressLabel  "+addressLabel);
		return addressLabel;		
	}
	
	
	public String getpickupAddressContent() {
		String addressContent=pickupAddressContent.getText();
		System.out.println("pickupAddressContent: " +addressContent);
		return addressContent;
	}

}
