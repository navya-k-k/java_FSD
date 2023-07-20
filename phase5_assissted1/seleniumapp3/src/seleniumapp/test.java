package seleniumapp;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class test {
public static void main(String[] args) throws InterruptedException {
// Basic configuration
WebDriver driver = new ChromeDriver();
TableDemo(driver);
}
// Locate and Process Table
static void TableDemo(WebDriver driver) {
String baseUrl = "https://www.nyse.com/ipo-center/recent-ipo";
driver.get(baseUrl);
driver.manage().timeouts().implicitlyWait(10, 
TimeUnit.SECONDS);
String tableXPath = 
"/html/body/div[1]/div[4]/div[2]/div[3]/div[1]/div[4]/table";
String tableXPathRow = 
"/html/body/div[1]/div[4]/div[2]/div[3]/div[1]/div[4]/table/tbody/tr";
List<WebElement> rowList = 
driver.findElements(By.xpath(tableXPathRow));
System.out.printf("\nTOTAL NUMBER OF ROWS = %s", 
rowList.size());
// Column count
String tableHeadingXPath = 
"/html/body/div[1]/div[4]/div[2]/div[3]/div[1]/div[4]/table/thead/tr/th";
List<WebElement> colList = 
driver.findElements(By.xpath(tableHeadingXPath));
System.out.printf("\nTOTAL NUMBER OF COLUMNS = %s \n", 
colList.size());
// Finding cell value at 4th row and 3rd column
WebElement cellAddress = driver.findElement(By.xpath(tableXPath
+ "/tbody/tr[4]/td[3]"));
String value = cellAddress.getText();
System.out.println("VALUE AT 4 ROW AND 3 COLUMN : " + value);
// Change the cell contents using JS
// JS Executor
JavascriptExecutor js = (JavascriptExecutor) driver;
String cssSelectScriptForCell3_3 = "var e =document.querySelector(\"body > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(9) > "
table > tbody > tr:nth-child(3) > td:nth-child(3) > strong\"); 
e.textContent='Bharat Gas'";
js.executeScript(cssSelectScriptForCell3_3);
}
}