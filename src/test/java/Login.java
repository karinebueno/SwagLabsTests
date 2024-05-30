import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login {

    private WebDriver driver;
    private String basePage;

    @BeforeEach
    public void BasicsToAccessTheWebpage (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roberto\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        basePage = "https://www.saucedemo.com/";
    }

    @Test
    @DisplayName("If the user field is empty, then a message error should appear")
    public void UserFieldEmpty (){
        driver.get(basePage);
        WebElement usernameField=driver.findElement(By.id("user-name"));
        usernameField.clear();
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.tagName("h3")).getText();
        assertEquals(text,"Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    @DisplayName("If the password field is empty, then a message error should appear")
     public void PasswordFieldEmpty (){
        driver.get(basePage);
        WebElement usernameField=driver.findElement(By.id("user-name"));
        String username="standard_use";
        usernameField.sendKeys(username);
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.clear();
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.tagName("h3")).getText();
        assertEquals(text,"Epic sadface: Password is required");
        driver.quit();
    }

    @Test
    @DisplayName("If the username and password fields are empty, then a message error should appear")
    public void UsernamePasswordFieldsEmpty (){
        driver.get(basePage);
        WebElement usernameField=driver.findElement(By.id("user-name"));
        usernameField.clear();
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.clear();
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.tagName("h3")).getText();
        assertEquals(text,"Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    @DisplayName("Successfull login")
    public void SuccessfulLogin (){
        driver.get(basePage);
        WebElement UsernameInput=driver.findElement(By.id("user-name"));
        String username="standard_user";
        UsernameInput.sendKeys(username);
        WebElement PasswordInput=driver.findElement(By.id("password"));
        String password="secret_sauce";
        PasswordInput.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String title = driver.getTitle();
        assertEquals(title, "Swag Labs");
    }

}
