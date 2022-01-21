package com.learn.serenity.authentication.actions;

import com.learn.serenity.authentication.User;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {

    @Step("Login as {0} ")
    public void as(User user) {

        openUrl("https://www.saucedemo.com/");
        $("#user-name").sendKeys(user.getUsername());
        $("#password").sendKeys(user.getPassword());
        $("#login-button").click();
    }
}
