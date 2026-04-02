package com.selenium.practice.com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver=new ChromeDriver();
      driver.get("https://www.amazon.in/");
      
      WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
      WebElement account=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-link-accountList")));
      Actions action=new Actions(driver);
      action.moveToElement(account).build().perform();
      action.keyDown(Keys.SHIFT).build().perform();
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hEllo");
	}

}
