package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.basedriver.BaseDriver;
import ui.utils.WebTable;

public class UserListHome extends BaseDriver {

    public UserListHome() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[type='add']")
    private WebElement addUser;

    @FindBy(xpath = "//table[@table-title='Smart Table example']")
    private WebElement userListTable;

    public void clickOnAddUser() {
        addUser.click();
    }

    public boolean isUserLandedOnUserListTable() {

        return userListTable.isDisplayed();
    }

    public boolean isNewUserPresentInTheList(String username) {
        WebTable webTable = new WebTable(userListTable);
        return webTable.isUserPresentInColumn(username);
    }

    public boolean isUsernameUnique() {
        WebTable webTable = new WebTable(userListTable);
        return webTable.isColumnDataUnique("User Name");
    }
}
