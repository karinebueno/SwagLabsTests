import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsFilter {
    private WebDriver driver;
    private String basePage;



    @BeforeEach
    public void BasicsToAccessTheWebpage (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roberto\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        basePage = "https://www.saucedemo.com/";
    }

    @AfterEach
    public void CloseEachTest(){
        driver.quit();
    }

    @Test
    @DisplayName("Checking on the arrow to select the filter option")
    public void ArrowSelectFilter (){
        driver.get(basePage);
        WebElement UsernameInput=driver.findElement(By.id("user-name"));
        String username="standard_user";
        UsernameInput.sendKeys(username);
        WebElement PasswordInput=driver.findElement(By.id("password"));
        String password="secret_sauce";
        PasswordInput.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//span[@class='select_container'][contains(.,'Name (A to Z)Name (A to Z)Name (Z to A)Price (low to high)Price (high to low)')]")).click();
        // Verifique se o dropdown está visível
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]"));
        boolean isDropdownVisible = dropdown.isDisplayed();
        if (isDropdownVisible) {
            System.out.println("O dropdown está visível após clicar na seta.");
        } else {
            System.out.println("O dropdown não está visível após clicar na seta.");
        }
    }


}
