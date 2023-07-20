package seleniumapp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement; // Add the import for WebElement
import java.io.IOException; // Add the import for IOException

public class test {
	
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		demoFileUpload(driver);
	}

	static void demoFileUpload(WebDriver driver) throws InterruptedException, IOException {
		String baseUrl = "https://demoqa.com/automation-practice-form";
		driver.get(baseUrl);
		Thread.sleep(2000);
		WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
		System.out.println("uploadFileElement details: " + uploadFileElement);
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\Phase5Test.exe");
	}
}
