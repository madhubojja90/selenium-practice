package com.selenium.practice.com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractiseWithWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
        List<WebElement> radios = driver.findElements(By.name("radio"));
        driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"user\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        WebElement okButton = wait.until(
        	    ExpectedConditions.elementToBeClickable(By.id("okayBtn"))
        	);
        	okButton.click();
        	Select options=new Select(driver.findElement(By.cssSelector("select[class=\"form-control\"]")));
        	options.selectByVisibleText("Consultant");
        	driver.findElement(By.cssSelector("input[id=\"terms\"]")).click();
        	driver.findElement(By.cssSelector("input[id=\"signInBtn\"]")).click();
        	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class=\"btn btn-info\"]")));
        List<WebElement> addbuttons=driver.findElements(By.cssSelector("button[class=\"btn btn-info\"]"));
        for(WebElement addbutton:addbuttons)
        {
        	addbutton.click();
        }
        driver.findElement(By.cssSelector("a[class=\"nav-link btn btn-primary\"]")).click();
        driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).click();
        driver.findElement(By.id("country")).sendKeys("india");
        WebElement country=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='suggestions']//a[text()='India']")));
        country.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for=\"checkbox2\"]")));
        WebElement checkbox = wait.until(
        	    ExpectedConditions.elementToBeClickable(By.id("checkbox2"))
        	);

        	if (!checkbox.isSelected()) {
        	    checkbox.click();
        	}
        driver.findElement(By.cssSelector("input[value=\"Purchase\"]")).click();
        	
        	
	}
}
