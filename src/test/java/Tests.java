
import org.testng.annotations.*;
import pages.CartPage;

import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 90;
    private static final String CORRECT_SEARCH_STRING = "HP ProBook 4540s";
    private static final String WRONG_SEARCH_STRING = "qwueyqiwueyiuqwyeiuqwey";

    @Test (priority = 1)
    public void checkEmptyCart() {
        getHomePage().open();
        CartPage cartPage = getHomePage().cardIconClick();
        assertTrue( cartPage.isEmptyCard() );
    }

    @Test (priority = 2)
    public void checkSearchFieldOnHomePageNegative() {
        getHomePage().open().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().isSearchFieldVisible();
        getHomePage().inputSearchField(WRONG_SEARCH_STRING);
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue(getHomePage().isNoResultTextVisible());
    }

    @Test(priority = 2)
    public void checkSearchFieldOnHomePagePositive() {
        getHomePage().open().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().inputSearchField(CORRECT_SEARCH_STRING);
        assertTrue(getHomePage().isProductVisible());
    }

    @Test(priority = 3)
    public void checkAddToCart() {
        getProductPage().open();
        //getProductPage().gdprButtonClick();
        assertTrue( getProductPage().isButtonAddToCartVisible());
        getProductPage().addButtonClick();
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue( getProductPage().isPopupVisible());
    }

}
