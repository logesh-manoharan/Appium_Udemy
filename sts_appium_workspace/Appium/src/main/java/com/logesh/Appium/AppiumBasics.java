package com.logesh.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {
	
	/*
	 * Going to use TestNG framework. Because, we are going to create a framework finally.
	 * 
	 * 
	 */
	
	
	@Test
	public void AppiumTest() throws MalformedURLException, InterruptedException {
		/*
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// Xpath - //<tagname>[@<attribute>='<value>']
		// Getting the 2nd occurence of '//android.widget.RelativeLayout'
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Logesh");
		
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();*/
//		serviceBuilder.stop();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		// Long Click Gesture (by using Element)
		longClickActionByElement(element);
		
		// we can use 'By.id()' for 'resource-id' as well
		org.testng.Assert.assertEquals(driver.findElement(By.id("android:id/title")).getText(), "Sample menu");
		org.testng.Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		Thread.sleep(5000);
		
	}

}
