package ui.utils;

import api.utils.ApiActions;
import config.Configuration;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import ui.basedriver.BaseDriver;
import ui.pages.AddUser;
import ui.pages.UserListHome;

public class UiActions extends BaseDriver {
    private static Logger Log = LogManager.getLogger(UiActions.class.getName());

    Configuration config = new Configuration();
    UserListHome userListHome = new UserListHome();
    AddUser addUser = new AddUser();

    public void navigateToBaseUrl() {
        Log.info("Navigating to the base URL: {}", config.getPropertyValue("WEB_URL"));
        webDriver.get(config.getPropertyValue("WEB_URL"));
    }

    public void validateUserListTableDisplayed() {
        Log.info("Validating if the user list table is displayed");
        Assertions.assertThat(userListHome.isUserLandedOnUserListTable()).isTrue();
        ScreenshotUtils.takeScreenshot(webDriver);
    }

    public void clickOnAddUser() {
        Log.info("Clicking on the 'Add User' button");
        userListHome.clickOnAddUser();
    }

    public void userProvidingTheDetails(String fname, String lname, String uname, String pwd, String company, String role, String email, String cellPhone) {
        Log.info("Providing user details - First Name: {}, Last Name: {}, Username: {}, Password: {}, Company: {}, Role: {}, Email: {}, Cell Phone: {}",
                fname, lname, uname, pwd, company, role, email, cellPhone);
        addUser.setFirstName(fname);
        addUser.setLastName(lname);
        addUser.setUserName(uname);
        addUser.setPassword(pwd);
        addUser.selectTheCompany(company);
        addUser.selectTheRole(role);
        addUser.setEmail(email);
        addUser.setCellPhone(cellPhone);
        ScreenshotUtils.takeScreenshot(webDriver);
        addUser.addTheUser();
    }

    public void validateNewUserAdditionInTheList(String username) {
        Log.info("Validating if the new user '{}' is added to the list", username);
        ScreenshotUtils.takeScreenshot(webDriver);
        Assertions.assertThat(userListHome.isNewUserPresentInTheList(username)).isTrue();
    }

    public void validateUserNameIsUnique() {
        Log.info("Validating if the username is unique");
        Assertions.assertThat(userListHome.isUsernameUnique()).isTrue();
    }
}
