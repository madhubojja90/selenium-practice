package com.selenium.practice.com.selenium.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdownpractise2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		//Locator-type="checkbox"
		
	  Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),3);
	    
	}

}
