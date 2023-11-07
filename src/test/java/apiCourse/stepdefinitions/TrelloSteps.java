package apiCourse.stepdefinitions;

import apiCourse.domain.Board;
import apiCourse.domain.List;
import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static apiCourse.clients.TrelloClient.*;
import static apiCourse.constants.ProjectsConstants.BOARD_ID;
import static apiCourse.constants.ProjectsConstants.BOARD_NAME;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);

        Assertions.assertThat(board.getId())
                .as("We assert that the board ID is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We assert that the board name is correct")
                .isEqualTo(BOARD_NAME);

    }

    @When("User changes the board title to {string}")
    public void changeBoardTitle(String title){
        Response response = changeBoardName(title, TestCaseContext.getBoard().getId());
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);
        System.out.println(TestCaseContext.getBoard().getName());
    }

    @And("User checks that the board name was updated to {string}")
    public void checkBoardTitle(String name){
        Assertions.assertThat(TestCaseContext.getBoard().getName())
                .as("We check that the board name was updated to " + name)
                .isEqualTo(name);
    }

    @Then("User adds a list with title {string} to the board")
    public void addNewList(String name){
        Response response = createList(name, TestCaseContext.getBoard().getId());
        List list = response.as(List.class);
        TestCaseContext.setList(list);

        Assertions.assertThat(list.getName())
                .as("The list was created with name " + name)
                .isEqualTo(name);
        TestCaseContext.getScenario().log("The list ID is: " + list.getId());
    }
}
