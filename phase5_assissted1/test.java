package seleniumapp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        
        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Step 1.5.1: Handling External Pop-ups

        // Navigate to a page with a pop-up (alert)
        driver.get("https://www.example.com");
        
        // Click a button or perform an action that triggers the pop-up
        // For demonstration purposes, assuming there is a button with ID "alertButton"
        driver.findElement(By.id("alertButton")).click();

        // Handling the alert - Accepting the pop-up (clicking on 'OK' button)
        driver.switchTo().alert().accept();

        // Step 1.5.2: Handling New Tabs and New Windows

        // Opening a new tab
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        
        // Navigate to the desired URL in the new tab
        driver.get("https://www.example.com/newtabpage");
        
        // Opening a new window
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
        
        // Navigate to the desired URL in the new window
        driver.get("https://www.example.com/newwindowpage");

        // Close the browser (this will close all tabs/windows)
        driver.quit();
    }
}
