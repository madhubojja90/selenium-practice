package com.selenium.practice.com.selenium.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownpractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Select dropdown=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("div#divpaxinfo")).click();
		for(int i=1; i<5;i++)
		{   Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.className("buttonN")).click();
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
		driver.quit();                                
	} 

}
