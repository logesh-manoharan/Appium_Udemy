package com.logesh.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragAndDropAction extends BaseTest {

	@Test
	public void dragAndDrop() throws InterruptedException {

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		dragAndDropAction(element, 652, 596);

		Thread.sleep(3000);

		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	}

}
