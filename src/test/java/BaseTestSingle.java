import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTestSingle {

    private  WebDriver driver;


    public WebDriver getDriver() {
        //return driver.get();
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }
    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }

}

