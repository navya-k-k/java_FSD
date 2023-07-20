package seleniumapp;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");;
		WebDriver  n = new ChromeDriver();
		n.get("http://www.linkedin.com/");
		n.findElement(By.id("session_key")).sendKeys("navyaaprakash1998@gmail.com");
		n.findElement(By.id("session_password")).sendKeys("Navya@1999");
		n.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button")).click();
		String u=n.getCurrentUrl();
		if(u.equals("https://www.linkedin.com/feed/"))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		
	}
	
	

}