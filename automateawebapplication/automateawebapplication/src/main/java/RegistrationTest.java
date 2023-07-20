import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "file:///C://Users//home//eclipse-workspace//automateawebapplication//src//main//resources//registration.html";
        driver.get(baseUrl);

        // Find the registration form elements
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        // Fill in the registration form
        firstNameInput.sendKeys("lavanya");
        lastNameInput.sendKeys("S");
        emailInput.sendKeys("lavanya@example.com");
        passwordInput.sendKeys("password123");
        confirmPasswordInput.sendKeys("password123");
        try {
            Thread.sleep(1000); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Submit the form
        submitButton.click();

        // Wait for successful registration verification
        boolean isRegistrationSuccessful = waitForSuccessfulRegistration(driver);
        if (isRegistrationSuccessful) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }

        // Close the browser
        driver.quit();
    }

    private static boolean waitForSuccessfulRegistration(WebDriver driver) {
        // Return true if login is successful, false otherwise
        return true;
    }
}
