package android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class NewTest {
	public static AndroidDriver driver;
	
	@Test
	public void prep() throws MalformedURLException, InterruptedException
	{
	
	 File app = new File("C:\\Users\\bkbc011\\Desktop\\apk\\production.apk");
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("automationName","appium");
     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
	 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
	 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	Thread.sleep(15000);
	try{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("button1")).click();
}catch(Exception e){System.out.println("TestFairy Element not found but the test will move forward");}
		
	try{	driver.findElement(By.id("text1")).click(); 
	}catch(Exception e){System.out.println("TestFairy Element not found but the test will move forward");}
		Thread.sleep(2000);
	Set<String> contextNames = driver.getContextHandles();
	     for (String contextName : contextNames) {
	       System.out.println(contextName);
	       if (contextName.contains("WEBVIEW")){
	         driver.context(contextName);
	     	Thread.sleep(15000);
	       }
	      }
	}
	
}
