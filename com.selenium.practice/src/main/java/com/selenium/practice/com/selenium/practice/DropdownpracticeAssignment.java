package com.selenium.practice.com.selenium.practice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownpracticeAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//count check boxes
		int size=driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size();
		System.out.println(size);
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
		for(WebElement option :options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
			option.click();
			break;
			}
		}
		driver.quit();
	}

}
