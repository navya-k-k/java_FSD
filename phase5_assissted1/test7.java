package seleniumapp;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
public class test {
public static void main(String[] args) throws Exception {
// Basic configuration
WebDriver driver = new ChromeDriver();
demoTakingScreenshot(driver);
}
static void demoTakingScreenshot(WebDriver driver) throws
IOException, InterruptedException {
String baseUrl = "https://www.amazon.in";
driver.get(baseUrl);
Thread.sleep(2000);
TakesScreenshot scrShot = ((TakesScreenshot) driver);
File imgTmpFile = scrShot.getScreenshotAs(OutputType.FILE);
File destinationFile = new File("C:/downloads/ScreenshotImage.jpg");
Files.copy(imgTmpFile, destinationFile);
}
}