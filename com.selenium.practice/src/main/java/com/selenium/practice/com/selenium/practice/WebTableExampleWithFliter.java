package com.selenium.practice.com.selenium.practice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableExampleWithFliter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
	    List<WebElement> VegList=driver.findElements(By.xpath("//tr/td[1]"));
	    List<WebElement> filterList=VegList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		System.out.println("Veglist size: "+VegList.size()+", FilterVegList size: "+filterList.size());
		Assert.assertEquals(filterList.size(),VegList.size());

	}

}
