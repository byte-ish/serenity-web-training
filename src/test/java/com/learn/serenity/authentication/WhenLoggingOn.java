package com.learn.serenity.authentication;

import com.learn.serenity.authentication.actions.LoginActions;
import com.learn.serenity.inventory.InventoryPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;
    @Steps
    LoginActions login;
    //Pages
    InventoryPage inventoryPage;
    @Test
    public void usersCanLoginViaHomePage() {

        //credentials test data moved to an ENUM class
        login.as(User.STANDARD_USER);

        //Make assertion part of the report
        // Should see product catalog
        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );
    }
}
