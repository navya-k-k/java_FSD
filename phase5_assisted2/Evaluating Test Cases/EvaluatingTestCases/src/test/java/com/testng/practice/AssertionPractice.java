package com.testng.practice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	WebDriver driver=null;
	SoftAssert soft=null;
  @Test
  public void TitleTest() {
	  
	  //testcase
	  driver.get("https://www.facebook.com/");
	  System.out.println(driver.getTitle());
	  
	  soft.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	  soft.assertAll();
	  
	 // driver.close();
  }
  
  @BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\\\Java FSD Software\\\\chrome\\\\chromedriver.exe");
		driver= new ChromeDriver();
		soft= new SoftAssert();
	}
	@AfterMethod
	public void afterMethod() {
		//driver.close();
		driver=null;
	}
}
