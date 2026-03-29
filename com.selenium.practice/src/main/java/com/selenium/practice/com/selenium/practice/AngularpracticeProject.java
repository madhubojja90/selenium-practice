package com.selenium.practice.com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AngularpracticeProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Madhu");
		driver.findElement(By.name("email")).sendKeys("madhubojja90@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Medhansh@123");
		driver.findElement(By.id("exampleCheck1")).click();
		Select dropdown=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dropdown.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("23-03-2025");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.className("alert-success")).getText());
	//	Assert.assertEquals(driver.findElement(By.className("alert-success")).getText(), "Success! The Form has been submitted successfully!.");
		String actual = driver.findElement(By.className("alert-success")).getText();
		Assert.assertTrue(actual.contains("Success! The Form has been submitted successfully!."));

	}

}
