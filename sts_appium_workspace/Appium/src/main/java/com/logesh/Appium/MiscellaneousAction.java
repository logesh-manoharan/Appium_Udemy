package com.logesh.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAction extends BaseTest {

	/*
	 * 1. Rotate screen
	 * 2. Clip board
	 * 3. Android keys
	 */
	
	@Test
	public void miscellaneousAction() {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		
		// To rotate 90 degree
		DeviceRotation landscapeRotate = new DeviceRotation(0, 0, 90);
		driver.rotate(landscapeRotate);
		
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		// Clip Board save
		driver.setClipboardText("Logesh");   // it is like COPYING the text["Logesh"]
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());  // it is like PASTING the text
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));   // To press <ENTER> button
		
		// Using Android KeyPads, Home, Back, Tasks Lists Buttons
		driver.pressKey(new KeyEvent(AndroidKey.BACK));   // To press <BACK> button
		driver.pressKey(new KeyEvent(AndroidKey.HOME));   // To press <HOME> button
		
	}
}
