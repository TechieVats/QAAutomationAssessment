package ui.basedriver;

import org.openqa.selenium.WebDriver;

public class ManageDriver {

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private ManageDriver() {

    }
    private static ManageDriver instance = new ManageDriver();

    public static ManageDriver getInstance() {
        return instance;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver.set(webDriver);
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }


}
