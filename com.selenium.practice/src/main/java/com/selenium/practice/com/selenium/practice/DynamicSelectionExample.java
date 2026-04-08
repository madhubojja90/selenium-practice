package com.selenium.practice.com.selenium.practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicSelectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String Option="Option3";
		String selectedLabelText="";
		WebElement checkBox=driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset"));
		////div[@id='checkbox-example']/fieldset/label
		System.out.println(checkBox.findElements(By.xpath(".//label")).size());
		List<WebElement> labels=checkBox.findElements(By.xpath(".//label"));
		for(WebElement label: labels)
		{
			//String text=label.getText();
			//System.out.println(text);
			if(label.getText().equals(Option))
			{
				label.findElement(By.tagName("input")).click();
				selectedLabelText=label.getText();
				System.out.println(selectedLabelText);
				break;
			}
			
		}
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select select=new Select(dropdown);
		select.selectByVisibleText(selectedLabelText);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selectedLabelText);
		driver.findElement(By.id("alertbtn")).click();
		Alert alert=driver.switchTo().alert();
	    Assert.assertTrue(alert.getText().contains(selectedLabelText), "Text not found in alert");
	    alert.accept();
	    driver.quit();
		
	}

}
