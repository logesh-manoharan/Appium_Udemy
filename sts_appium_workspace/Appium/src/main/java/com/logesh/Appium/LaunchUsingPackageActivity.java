package com.logesh.Appium;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class LaunchUsingPackageActivity extends BaseTest {
	
	public void launchUsingPackageActivity() {
		
		/*
		 * Execute Command to get the current page's Package and Activity
		 * 
		 * $adb shell dumpsys window | find “mCurrentFocus”   [For Windows]
		*/
		
		// To launch the PAGE automatically
		Activity activity = new Activity("", "");
		driver.startActivity(activity);

	}
	
}
