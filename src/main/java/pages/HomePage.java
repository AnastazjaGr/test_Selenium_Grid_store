package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    protected static final String URL = "https://www.ebay.com";

    @FindBy(xpath = "//div[@id=\"gh-ac-box2\"]/input[@type=\"text\"]")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id=\"s0-14-11-6-3-save_search1-answer-18\"]/div[@class=\"srp-save-null-search__title\"]/h3")
    private WebElement noResultText;

    @FindBy(xpath = "//div[@id=\"srp-river-results\"]//h3[contains (text(),\"HP ProBook 4540s\")]")
    private WebElement product;

    @FindBy(xpath = "//li[@id=\"gh-minicart-hover\"]//a")
    private WebElement cardIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void inputSearchField(String input) {
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.RETURN);
    }

    public boolean isNoResultTextVisible() {
        waitVisibilityOfElement( noResultText);
        return noResultText.getText().equalsIgnoreCase("No exact matches found");
    }

    public boolean isProductVisible() {
        waitVisibilityOfElement( product);
        return   product.isDisplayed();
    }

    public void   productClick() {
        product.click();
    }

    public CartPage   cardIconClick() {
        cardIcon.click();
        return new CartPage(driver);
    }

}
