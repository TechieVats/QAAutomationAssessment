package ui.basedriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseDriver {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    BrowserFactory browserFactory = new BrowserFactory();
    public BaseDriver() {
        webDriver = ManageDriver.getInstance().getDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }
}
