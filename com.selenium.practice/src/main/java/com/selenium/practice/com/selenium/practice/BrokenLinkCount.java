package com.selenium.practice.com.selenium.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkCount {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        SoftAssert a=new SoftAssert();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
       
        List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));
        int totalLinks = links.size();
        int brokenLinks = 0;
        for(WebElement link:links)
        {
       String url= link.getAttribute("href");
       HttpURLConnection con=(HttpURLConnection) new URI(url).toURL().openConnection();
       con.setRequestMethod("HEAD");
       con.connect();
       int StatuCode=con.getResponseCode();
       if(StatuCode>400) {
    	   brokenLinks++;
       a.assertTrue(
    		   false,
               "Broken link found: " + url + " | Status Code: " + StatuCode
           );

        }
        }
       
        System.out.println(totalLinks);
        System.out.println(brokenLinks);
        a.assertAll();
       
	}
	

}
