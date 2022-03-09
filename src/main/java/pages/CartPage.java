package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class=\"font-title-3\"]/span")
    private WebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmptyCard() {
        waitVisibilityOfElement( cartTitle);
        return cartTitle.getText().contains("You don't have any items in your cart.");
    }

}
