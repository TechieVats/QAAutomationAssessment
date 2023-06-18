package ui.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.utils.UiActions;

public class WebTables {

    UiActions uiActions = new UiActions();

    @Given("user navigate to the base url")
    public void userNavigateToThe() {
        uiActions.navigateToBaseUrl();
    }

    @Then("user validates that user landed on the user list table")
    public void userValidatesThatUserLandedOnTheUserListTable() {
        uiActions.validateUserListTableDisplayed();
    }

    @When("user clicks the add user button")
    public void userClicksTheAddUserButton() {
        uiActions.clickOnAddUser();
    }

    @And("provide the details as {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void provideTheDetailsAsAnd(String fname, String lname, String uname, String pwd, String company, String role, String email, String cellPhone) {
        uiActions.userProvidingTheDetails(fname, lname, uname, pwd, company, role, email, cellPhone);
    }

    @Then("user validates the newly added {string} is added to the list")
    public void userValidatesTheNewlyAddedIsAddedToTheList(String username) {
        uiActions.validateUserNameIsUnique();
        uiActions.validateNewUserAdditionInTheList(username);
    }

}
