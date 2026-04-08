package com.selenium.practice.com.selenium.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinksFromGivenPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Entire page -Links Count
		System.out.println("Entire page -Links Count- "+driver.findElements(By.tagName("a")).size());
		
		//Logic for Footer Links Count using webdriver scope
		
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println("Footer page -Links Count- "+footerdriver.findElements(By.tagName("a")).size());
		
		WebElement coloumnLinkCount=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("footer 1dt coloumn page -Links Count- "+coloumnLinkCount.findElements(By.tagName("a")).size());
		
		for(int i=1;i<coloumnLinkCount.findElements(By.tagName("a")).size();i++)
		{
			String controlclik=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumnLinkCount.findElements(By.tagName("a")).get(i).sendKeys(controlclik);
			
		}
		Thread.sleep(30000);
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
		    driver.switchTo().window(it.next());
		    System.out.println(driver.getTitle());
		}
		
	}

}
