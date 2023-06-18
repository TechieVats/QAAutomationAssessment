package ui.hooks;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ui.basedriver.BrowserFactory;
import ui.basedriver.ManageDriver;

public class UiHooks {
    BrowserFactory factory = new BrowserFactory();

    @Before("@AddUsersToUserListTable")
    public void launchingTheBrowser(Scenario scenario) {
        factory.initialization();
    }

    @After("@AddUsersToUserListTable")
    public void closeTheBrowser() {
        ManageDriver.getInstance().getDriver().quit();
    }


}
