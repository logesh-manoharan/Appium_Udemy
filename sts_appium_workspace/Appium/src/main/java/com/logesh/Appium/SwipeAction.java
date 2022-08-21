package com.logesh.Appium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeAction extends BaseTest {
	
	@Test
	public void swipeAction() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();

		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();

		WebElement element = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));

//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
//				((RemoteWebElement) element).getId(), "direction", "left", "percent", 0.75));

		swipeByElement(element, "left");
		
		Thread.sleep(3000);
	}
	
	
}
