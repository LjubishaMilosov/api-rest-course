package apiCourse.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")

    public void getBoardAndCheckInfo(){
        System.out.println("The board exists and contains the correct information");
    }

    @When("User changes the board title to {string}")
    public void changeBoardTitle(String title){
        System.out.println("The newboard title is" + title);
    }

    @And("User checks that the board name was updated to {string}")

    public void checkBoardTitle(String name){
        System.out.println("Board name is " + name);
    }

    @Then("User adds a list with title {string} to the board")

    public void addNewList(String name){
        System.out.println("Created new list: " + name);
    }
}
