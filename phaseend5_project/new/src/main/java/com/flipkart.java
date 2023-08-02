package com;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class flipkart {

	private WebDriver driver;
	private WebDriver fDriver;

	@BeforeMethod
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Navigation() throws InterruptedException {

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		String url = driver.getCurrentUrl();
		AssertJUnit.assertEquals("https://www.flipkart.com/", url);
		System.out.println("Navigation success");

	}

	@Test(priority = 2)
	public void LaodingPage() throws InterruptedException {

		long start = System.currentTimeMillis();

		long finish = System.currentTimeMillis();
		long Loadtime = finish - start;
		System.out.println("Page Load Time = " + Loadtime + "milliseconds");
		long expectedtime = 30000;
		if (Loadtime < expectedtime) {
			System.out.println("Loading Page success");
		} else {
			System.out.println("Page load exceeded time");
		}

	}

	@Test(priority = 3)
	public void Search() throws InterruptedException {

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		driver.findElement(By.name("q")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("iPhone 13", Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("search product success");

	}

	@Test(priority = 4)
	public void LoadingImage() throws InterruptedException {

		driver.get("https://www.flipkart.com/search?q=realme&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		WebElement we1 = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[4]/div/div/div/a/div[1]/div[1]/div/div/img"));
		if (we1.isDisplayed()) {
			System.out.println("image not present");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		if (we1.isDisplayed()) {
			System.out.println("image present");
		}

	}
	@Test(priority = 5)
	public void Browser() throws InterruptedException {
		fDriver = new FirefoxDriver();

		fDriver.manage().window().maximize();
		fDriver.get("https://www.flipkart.com/");
		System.out.println("Browser change success");
			Thread.sleep(2000);
		fDriver.close();
	}
	

	@Test(priority = 6)
	public void ScrollPage() throws InterruptedException {

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
			System.out.print("page scroll success");
		
	}

	@Test(priority = 7)
	public void Refresh() throws InterruptedException {

		driver.get("https://www.flipkart.com/search?q=iphone+13&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_3_na_na_na&as-pos=1&as-type=RECENT&suggestionId=iphone+13%7CMobiles&requestId=ee111f6f-1edd-495d-9c8a-eec51bb9a9d5&as-searchtext=iph");
		long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// specify the WebElement till which the page has to be scrolled
		WebElement element = driver.findElement(By.xpath("//div[@class='CXW8mj']"));

		js.executeScript("arguments[0].scrollIntoView();", element);

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("content refresh success " + totalTime + " milliseconds");

	}

	@Test(priority = 8)
	public void Bottom() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("bottom navigation success");

	}

	@Test(priority = 9)
	public void Resolution() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.manage().window().setSize(new Dimension(1620, 820));
		Thread.sleep(3000);
		WebElement textField = driver.findElement(By.name("q"));
		textField.sendKeys("Iphone 13");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.navigate().back();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.manage().window().setSize(new Dimension(240, 360));
		textField.sendKeys("mini");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)", "");
		System.out.println("Resolution success");

	}
	@Test(priority = 5)
	public void ScreenHeight() throws InterruptedException {

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		java.awt.Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screen_size.getHeight();
		int width = (int) screen_size.getWidth();
		System.out.println("screen resolution");
		System.out.println("Height : " + height + "\nWidth : " + width);
		int img_height = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img"))
				.getSize().getHeight();
		int img_width = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img"))
				.getSize().getWidth();
		System.out.println("image resolution");
		System.out.println("Height " + img_height + "\nWidth " + img_width);
		WebElement img = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[3]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/a/div[1]/div/img"));
		if (img.isDisplayed()) {
			if (img_height < height && img_width < width) {
				System.out.println("The images are loaded and visible till the screen height only");
			} else {
				System.out.println("The images are not loaded and visible till the screen height");
			}
		}

	}
	

	@AfterTest
	@AfterMethod
	public void quitbrowser() throws InterruptedException {
		Thread.sleep(15000);
		driver.quit();

	}
}