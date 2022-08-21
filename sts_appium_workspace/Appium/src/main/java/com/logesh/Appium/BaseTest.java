package com.logesh.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public AndroidDriver driver;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		// Starting the service also need to be automated while we move this in Jenkins

		// To start the Appium server from CODE itself (No need to start the Appium
		// server everytime manually)
		// AppiumDriverLocalService serviceBuilder = new
		// AppiumServiceBuilder().withAppiumJS(new
		// File("C://Users//lmanoh572//.appium//node_modules//appium//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		// serviceBuilder.start();

		// Adding Capabilities
		UiAutomator2Options capabilities = new UiAutomator2Options();
		capabilities.setDeviceName("Logesh Pixel 4");
		capabilities.setApp(
				"C://Users//lmanoh572//Documents//Appium_Udemy//Resources//APKFiles//resources//ApiDemos-debug.apk");

		// Through APPIUM Server we will fetch the specific APP from Specific Device
		String appiumServerUrl = "http://127.0.0.1:4723";
		driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Long Click Action Utility
	public void longClickActionByElement(WebElement element) {

		// Creating the Properties for the Long Click Gesture
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("elementId", ((RemoteWebElement) element).getId());
		propertiesMap.put("duration", 3000); // long click for 3 seconds

		System.out.println("### DOING LONG CLICK ###");

		// Long Click Gesture (by using Element)
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", propertiesMap);
	}

	// Scroll till the Element using UiScrollable [i.e. Directly interacting with
	// Android's UIAutomator]
	// Prefer this Method
	public void scrollTillElementByUIAutomator(String text) {
		// Reference URL:
		// https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable

		// It will SCROLL till the element
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))"));
	}

	// Scroll till the Element using JS Event
	public void scrollTillElementByJsEvent(WebElement element, String direction) {
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("top", 100);
		propertiesMap.put("left", 100);
		propertiesMap.put("width", 200);
		propertiesMap.put("height", 200);
		propertiesMap.put("direction", direction);
		propertiesMap.put("percent", 3.0);

		// We can use below syntax instead of 'propertiesMap'
		// ImmutableMap.of("top", 100, "left", 100, "width", 200, "height", 200,
		// "direction", direction, "percent", 3.0);

		boolean isStillScrollable;
		boolean isElementDisplayed = false;

		do {
			try {
				if (element.isDisplayed()) {
					isElementDisplayed = true;
				}
			} catch (NoSuchElementException exp) {
				isElementDisplayed = false;
			}
			isStillScrollable = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					propertiesMap);
		} while (isStillScrollable && !isElementDisplayed);
	}

	// Scroll till the END
	public void scrollTillEnd(String direction) {
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("top", 100);
		propertiesMap.put("left", 100);
		propertiesMap.put("width", 200);
		propertiesMap.put("height", 200);
		propertiesMap.put("direction", direction);
		propertiesMap.put("percent", 3.0);

		// We can use below syntax instead of 'propertiesMap'
		// ImmutableMap.of("top", 100, "left", 100, "width", 200, "height", 200,
		// "direction", direction, "percent", 3.0);

		boolean isStillScrollable;

		// Scroll till the End
		do {
			isStillScrollable = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					propertiesMap);
		} while (isStillScrollable);
	}

	public void swipeByElement(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "left", "percent", 0.75));
	}

	// Drag an element
	public void dragAndDropAction(WebElement element, int dropEndX, int dropEndY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", dropEndX, "endY", dropEndY));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
