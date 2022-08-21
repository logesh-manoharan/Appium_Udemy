package com.logesh.Appium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollAction extends BaseTest {
	
	@Test
	public void scrollAction() {
		
		/*
		 * Reference:
		 * 
		 * Using UIAutomator : https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable
		 * 
		 */
			
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		
		// It will SCROLL till the element
		// URL : https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
//		scrollTillElementByUIAutomator("WebView");
		
		
		/*
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("top", 100);
		propertiesMap.put("left", 100);
		propertiesMap.put("width", 200);
		propertiesMap.put("height", 200);
		propertiesMap.put("direction", "down");
		propertiesMap.put("percent", 3.0);
		
		
		boolean isStillScrollable;
		boolean isElementDisplayed = false;
		
		do {
			try {
				if (driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Spinner']")).isDisplayed()) {
					isElementDisplayed = true;
				}
			} catch (NoSuchElementException exp) {
				isElementDisplayed = false;
			}
			isStillScrollable = (boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", propertiesMap);
		} while(isStillScrollable && !isElementDisplayed);
		
		*/
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='WebView']"));
		scrollTillElementByJsEvent(element, "down");
		
	}
	
}
