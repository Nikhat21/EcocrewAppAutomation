package org.ecocrewFramework.TestUtils;

import java.io.File;
import java.util.Properties;
import java.net.URL;
import java.time.Duration;

import java.io.FileInputStream;
import java.io.IOException;

import org.ecocrew.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest extends AppiumUtils{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\ecocrew\\resources\\data.properties");
				
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		
		System.out.println(ipAddress);
		String port=prop.getProperty("port");
				
	service = startAppiumServer(ipAddress,Integer.parseInt(port));
				
	UiAutomator2Options options=new UiAutomator2Options();
	options.setDeviceName(prop.getProperty("AndroidDeviceNames"));
	System.out.println(prop.getProperty("AndroidDeviceNames"));
	options.setApp("D:\\automationProjects\\src\\test\\java\\resources\\ecocrewuserapp.apk");
	//options.setApp(System.getProperty("user.dir")+ "\\src\\test\\java\\resources\\ecocrewuserapp.apk");
	 driver = new AndroidDriver(service.getUrl(), options);
		
	
		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();;
	    service.stop();
	}
}
