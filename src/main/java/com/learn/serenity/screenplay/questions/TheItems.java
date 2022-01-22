package com.learn.serenity.screenplay.questions;

import com.learn.serenity.screenplay.user_iterface.TodoList;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class TheItems {

    public static Question<List<String>> displayed() {

        return Text.of(TodoList.ITEMS)
                .describedAs("the items displayed")
                .asListOf(String.class);

    }
}
