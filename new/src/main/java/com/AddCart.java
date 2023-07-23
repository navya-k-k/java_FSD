package com;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class AddCart {
	WebDriver driver;
  @Test
  public void AddCart() {
	
	  try {
	  driver.get("https://www.amazon.com/");
	  driver.manage().window().maximize();
	  
	  System.out.println("Title : "+driver.getTitle());
	  System.out.println("*****************************************");
	  
//	  Search Bar
	  
	  driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("oneplus");
	  System.out.println("Search bar");
	  
//	  Search Button
	  
	  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  System.out.println("searching...");
	  
//	  open 
	  
	  driver.findElement(By.linkText("OnePlus Nord N200 | Large 5000mAh Battery | 5G Unlocked Android Smartphone U.S Version | 64GB Storage | 6.49\" Full HD+LCD Screen | 90Hz Smooth Display | Fast Charging | Triple Camera,Blue Quantum")).click();
	  System.out.println("view the mobile details");
	  
//	  Add to Cart
	  
//	  driver.findElement(By.id("add-to-cart-button")).click();
	  driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	  System.out.println("add to cart successfully");
	  
//	  Screenshot
	  
	  TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("C:\\Users\\User\\OneDrive\\Pictures\\Screenshots\\amazon.jpg"));
			System.out.println("Screenshot taken successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
//	 close browser
	  
	  driver.close();
	  System.out.println("browser closed successfully");
	  
	  }
	  catch(NoSuchElementException e) {
			e.printStackTrace();
		}
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver = null;
  }

}



