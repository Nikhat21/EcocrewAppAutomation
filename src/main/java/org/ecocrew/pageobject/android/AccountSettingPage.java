package org.ecocrew.pageobject.android;

import org.ecocrew.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountSettingPage extends AndroidAction{
   
AndroidDriver driver;
	
	public AccountSettingPage(AndroidDriver driver) {
       super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AccountScreenMy orders']")
	private WebElement myOrders;
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Contribution']")
	private WebElement myContribution;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONGOING']")
	private WebElement onGoing;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.editOrderActivityOngoing']/android.widget.TextView[3]")
	private WebElement pickupStatus;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CANCELLED']")
	private WebElement cancelled;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AccountScreenSaved addresses']")
	private WebElement Savedaddresses;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SAVED ADDRESSES']")
	private WebElement SavedaddressesScreen;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AccountScreenMy referrals']")
	private WebElement MyreferralsMenu;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Share Link']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
	private WebElement shareLink;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='My Referrals']/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
	private WebElement MyReferrals;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ecocrew.AccountScreenLog out']")
	private WebElement logout;
	
	
	
	
	public void myOrdersMenu(){
		myOrders.click();
	}
	

	public String myContributionTab(){
		String myContributionLabel=myContribution.getText();
		System.out.println("myContributionLabel: " +myContributionLabel);
		return myContributionLabel;
	}
	
	public String onGoingButton(){
		String ongoingbtnLabel=onGoing.getText();
		System.out.println("ongoingbtnLabel: " +ongoingbtnLabel);
		return ongoingbtnLabel;
	}
	
	
	
	public String pickUpStatus(){
		String pickupStatusText=pickupStatus.getText();
		System.out.println("pickupStatusText: " +pickupStatusText);
		return pickupStatusText;
	}
	
	public String cancelledButton(){
		String cancelledText=cancelled.getText();
		System.out.println("cancelledText: " +cancelledText);
		return cancelledText;
	}
	
	public void SavedaddressesMenu(){
		Savedaddresses.click();
	}
	
	public String savedAddressesPage(){
		String savedaddressesText=SavedaddressesScreen.getText();
		System.out.println("savedaddresses: " +savedaddressesText);
		return savedaddressesText;
	}
	
	public void myreferralsMenu(){
		MyreferralsMenu.click();
	}
	
	public String shareLinkTab(){
		String shareLinkText=shareLink.getText();
		System.out.println("shareLinkText: " +shareLinkText);
		return shareLinkText;
	}
	
	public void myReferralsTab(){
		swipeAction(MyReferrals,"Right");
//		MyReferrals.click();
		
	}
	
	public void  scroll() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Log out\").instance(0));"));
	//scrollToText("Log out");	
	}
	
	
	public void logoutUser() {
		
		logout.click();
	}
	
}
