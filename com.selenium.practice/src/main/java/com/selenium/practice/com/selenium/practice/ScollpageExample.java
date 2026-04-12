package com.selenium.practice.com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScollpageExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 WebDriver driver=new ChromeDriver();
 driver.get("https://rahulshettyacademy.com/AutomationPractice");
 JavascriptExecutor js=(JavascriptExecutor)driver;
 js.executeScript("window.scroll(0,600)");
//div[@class='tableFixHead']   //td[4]
 js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=50000");
 List<WebElement> amounts=driver.findElements(By.xpath("//div[@class='tableFixHead']   //td[4]"));
 int sum=0;
 for(int i=0;i<amounts.size();i++)
 {
	 sum=sum+Integer.parseInt(amounts.get(i).getText());
 }
 System.out.println(sum);
 
int actual=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
 Assert.assertEquals(actual, sum);
 
 
 
	
	}

}
