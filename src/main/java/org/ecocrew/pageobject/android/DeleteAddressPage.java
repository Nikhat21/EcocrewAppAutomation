package org.ecocrew.pageobject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DeleteAddressPage extends AddAddressPage {
	AndroidDriver driver;
	
	public DeleteAddressPage(AndroidDriver driver) {
        super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.deleteAddressOnMyAddress']")
	List<WebElement> addressDeleteIcon;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.confirmDeleteAddressOnMyAddress']/android.widget.TextView")
	private WebElement confirmDeleteButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ecocrew.cancelDeleteAddressOnMyAddress']/android.widget.TextView")
	private WebElement cancelButton;

//	public void addressDelete() {
//		addressDeleteIcon.get(1).click();
//	}
	
	
	public void confirmDelete() {
		String delete=confirmDeleteButton.getText();
		System.out.println("Addressdeletebuttoncaption" +delete);
		confirmDeleteButton.click();
	}
	
	
	public void cancel() {
		String cancelBtn=cancelButton.getText();
		System.out.println("Addresscancelbuttoncaption" +cancelBtn);

		cancelButton.click();
	}
	
	
	public void deleteButton(String tabs) throws InterruptedException {
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
	      		addressDeleteIcon.get(i).click();	      
	      		System.out.println("Deleted successfully");
	      	  }else {
	      		  System.out.println("Address  not deleted ");
	      	  }
	}

	}


}