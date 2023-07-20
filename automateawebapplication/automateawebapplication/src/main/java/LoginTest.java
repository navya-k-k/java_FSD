import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "file:///C://Users//home//eclipse-workspace2//automateawebapplication//src//main//resources//login.html";
        driver.get(baseUrl);

        // Find the login form elements
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

     // Fill in the login form
        emailInput.sendKeys("lavanya@example.com");

        passwordInput.sendKeys("password123");
     // Add a delay between entering email and password fields
        try {
            Thread.sleep(1000); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Submit the form
        submitButton.click();

        // Wait for successful login verification
        // Add appropriate code here to verify successful login
        boolean isLoggedIn = verifySuccessfulLogin(driver);
        if (isLoggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        // Close the browser
        driver.quit();
    }

    private static boolean verifySuccessfulLogin(WebDriver driver) {
        // Return true if login is successful, false otherwise
        return true;
    }
}
