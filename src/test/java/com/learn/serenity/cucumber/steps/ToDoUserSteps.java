package com.learn.serenity.cucumber.steps;

import com.learn.serenity.screenplay.questions.TheItems;
import com.learn.serenity.screenplay.tasks.AddATodoItem;
import com.learn.serenity.screenplay.tasks.Start;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.BeforeExample;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.model.TestOutcome;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.hasItem;

public class ToDoUserSteps {

    //Setting the stage
    @Before
    public void set_the_stage() {
        setTheStage(new OnlineCast());
    }

    @Before
    public void cucumberBeforeScenario() {
        System.out.println("CUCUMBER BEFORE");
    }

    @BeforeScenario
    public void beforeScenario(TestOutcome outcome) {
        System.out.println("BEFORE SCENARIO " + outcome.getName());
    }

    @BeforeScenario
    public void beforeAScenario() {
        System.out.println("BEFORE SCENARIO");
    }

    @BeforeExample
    public void beforeExample() {
        System.out.println("BEFORE EXAMPLE");
    }


    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }
/*

    @ParameterType("All|Active|Completed")
    public TodoStatusFilter filter(String filter) {
        return TodoStatusFilter.valueOf(filter);
    }
*/

   /* @ParameterType(".*")
    public List<String> items(String listOfItems) {
        return Splitter.on(",").trimResults().omitEmptyStrings().splitToList(listOfItems);
    }*/

    @Given("that {actor} has an empty todo list")
    public void thatJamesHasAnEmptyTodoList(Actor actor) {
        actor.wasAbleTo(Start.withAnEmptyTodoList());
    }

    @When("{actor} adds {string} to his/her list")
    public void adds_to_his_list(Actor actor, String item) {
        actor.attemptsTo(AddATodoItem.called(item));
    }

    @Then("{string} should be recorded in his/her list")
    public void item_should_be_recorded_in_the_list(String expectedItem) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(),hasItem(expectedItem)));
    }

    @Given("that Jane has a todo list containing Buy some milk, Walk the dog")
    public void thatJaneHasATodoListContainingBuySomeMilkWalkTheDog() {
    }

    @When("she adds {string} to her list")
    public void sheAddsBuySomeCerealToHerList() {
    }

    @Then("her todo list should contain Buy some milk, Walk the dog, Buy some cereal")
    public void herTodoListShouldContainBuySomeMilkWalkTheDogBuySomeCereal() {
    }

    @Given("that James has a todo list containing Buy some milk, Walk the dog")
    public void thatJamesHasATodoListContainingBuySomeMilkWalkTheDog() {
    }

    @And("that Jill has a todo list containing Buy some milk, Buy some cheese")
    public void thatJillHasATodoListContainingBuySomeMilkBuySomeCheese() {
    }

    @Then("Jill's todo list should contain Buy some milk, Buy some cheese, Buy some cereal")
    public void jillSTodoListShouldContainBuySomeMilkBuySomeCheeseBuySomeCereal() {
    }

    @And("James's todo list should contain Buy some milk, Walk the dog")
    public void jamesSTodoListShouldContainBuySomeMilkWalkTheDog() {
    }
}
