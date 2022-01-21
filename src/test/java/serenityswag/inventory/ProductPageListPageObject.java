package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductPageListPageObject extends PageObject {
    public List<String> getProductTitles() {
        return findAll(By.className("inventory_item_name")).textContents();
    }
}
