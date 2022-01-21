package serenityswag.inventory;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenViewingHighlightedProducts {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;
    ProductPageListPageObject productPageListPageObject;

    @Test
    public void shouldDisplayHighlightedProducts() {
        login.as(STANDARD_USER);

        List<String> productsOnDisplay = productPageListPageObject.getProductTitles();
        assertThat(productsOnDisplay).hasSize(6)
                .contains("Sauce Labs Backpack");

    }
}
