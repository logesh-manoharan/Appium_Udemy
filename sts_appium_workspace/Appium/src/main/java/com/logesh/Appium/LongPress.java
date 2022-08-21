package com.logesh.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	
	@Test
	public void longPress() throws InterruptedException {
		
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
