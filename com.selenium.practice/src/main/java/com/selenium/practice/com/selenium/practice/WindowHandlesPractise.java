package com.selenium.practice.com.selenium.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator=windows.iterator();
        String parentWindow=iterator.next();
        String childWindow=iterator.next();
        driver.switchTo().window(childWindow);
       System.out.println( driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
       String username= driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
       driver.switchTo().window(parentWindow);
       driver.findElement(By.id("username")).sendKeys(username);

}
}
