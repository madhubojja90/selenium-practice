package com.selenium.practice.com.selenium.practice;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableExampleWithSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> expectedList=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList=expectedList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList=expectedList.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		Assert.assertTrue(sortedList.equals(originalList));
		List<String> price;
		do {
			List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
		price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
		price.forEach(pricevalue->System.out.println(pricevalue));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method st
		String price=s.findElement(By.xpath("following-sibling::td")).getText();
		return price;
	}

}
