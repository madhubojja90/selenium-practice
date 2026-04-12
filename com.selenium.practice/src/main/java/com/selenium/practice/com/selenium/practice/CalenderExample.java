package com.selenium.practice.com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year="1998";
		String  month="4";
		String day="13";
		String[] expectedDate= {month,day,year};
		
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
      
        while(driver.findElements(By.xpath("//button[text()='"+year+"']")).isEmpty())
        {
        	driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
        }
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
        
        for(int i=0; i<driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")).size();i++)
        {
        	System.out.println(driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")).get(i).getAttribute("value"));
        	Assert.assertEquals(driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")).get(i).getAttribute("value"), expectedDate[i]);
        }
        
   driver.quit();
        
	}

}
