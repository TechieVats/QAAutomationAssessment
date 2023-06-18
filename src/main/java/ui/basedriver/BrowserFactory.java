package ui.basedriver;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    Configuration config = new Configuration();

    protected void setDriver() {
        WebDriver webDriver = initiatingTheBrowser();
        ManageDriver.getInstance().setWebDriver(webDriver);
    }

    public void initialization() {
        setDriver();
    }
    public WebDriver initiatingTheBrowser() {
        try {
            WebDriver webDriver = null;
            String browser = config.getPropertyValue("BROWSER").toUpperCase();
            switch (browser) {
                case "CHROME" -> {
                    String chromePath = System.getProperty("user.dir") + config.getPropertyValue("CHROME_PATH");
                    System.setProperty("webdriver.chrome.driver", chromePath);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    webDriver = new ChromeDriver(chromeOptions);
                    webDriver.manage().window().maximize();
                }

                case "FIREFOX" -> {
                    String firefoxPath = System.getProperty("user.dir") + config.getPropertyValue("FIREFOX_PATH");
                    System.setProperty("webdriver.gecko.driver", firefoxPath);
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().maximize();
                }

                default -> throw new UnsupportedOperationException("Unsupported browser: " + browser);
            }
            return webDriver;
        } catch (WebDriverException e) {
            throw new RuntimeException("Error while configure the webdriver");
        }

    }
}
