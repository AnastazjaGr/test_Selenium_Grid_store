package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class ProductPage extends BasePage {


    protected static final String URL = "https://www.ebay.com/itm/324920826756";

    @FindBy(xpath = "//a[@id=\"atcRedesignId_btn\"]")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//h2[@class=\"vi-overlayTitleBar\"]")
    private WebElement textInPopup;

   // @FindBy(xpath = "//button[@id=\"gdpr-banner-accept\"]")
    @FindBy(xpath = "//button[@id=\"gdpr-banner-decline\"]")
    private WebElement gdprButton;

    public ProductPage open() {
        driver.get(URL);
        return this;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isButtonAddToCartVisible() {
        waitVisibilityOfElement( buttonAddToCart);
        return buttonAddToCart.isDisplayed();
    }

    public void addButtonClick() {
        buttonAddToCart.click();
    }

    public void gdprButtonClick() {
        waitVisibilityOfElement(gdprButton);
        gdprButton.click();
    }

    public boolean isPopupVisible() {
        waitVisibilityOfElement( textInPopup);
        return textInPopup.getText().contains("item added to cart");
    }


}
