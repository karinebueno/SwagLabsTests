import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessToTheWebsite {

    private WebDriver driver;
    private String basePage;

    @BeforeEach
    public void BasicsToAccessTheWebpage (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roberto\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        basePage = "https://www.saucedemo.com/";
    }



    @Test
    @DisplayName("When I access the website, the Tile should be Swag Labs")
    public void AccessSwagLabs (){
        driver.get(basePage);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
        driver.quit();
    }

}
