package com.learn.serenity.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.learn.serenity.screenplay.user_iterface.TodoList.WHAT_NEEDS_TO_BE_DONE;

public class AddATodoItem {

    public static Task called(String thingToDo) {
        return Task.where("{0} adds a todo item called: #thingToDo",
                        Enter.theValue(thingToDo)
                                .into(WHAT_NEEDS_TO_BE_DONE)
                                .thenHit(Keys.RETURN))
                .with("thingToDo")
                .of(thingToDo);

    }
}
