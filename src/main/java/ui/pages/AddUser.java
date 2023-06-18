package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.basedriver.BaseDriver;

public class AddUser extends BaseDriver {

    public AddUser() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[name='FirstName']")
    private WebElement firstName;

    @FindBy(css = "[name='LastName']")
    private WebElement lastName;

    @FindBy(css = "[name='UserName']")
    private WebElement userName;

    @FindBy(css = "[name='Password']")
    private WebElement password;

    @FindBy(css = "[value='15']")
    private WebElement companyAAA;

    @FindBy(css = "[value='16']")
    private WebElement companyBBB;
    @FindBy(css = "[name='RoleId']")
    private WebElement role;

    @FindBy(css = "[name='Email']")
    private WebElement email;

    @FindBy(css = "[name='Mobilephone']")
    private WebElement cellPhone;

    @FindBy(css = "[ng-click='save(user)']")
    private WebElement submit;

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void selectTheCompany(String company) {
        if (company.contains("AAA")) {
            companyAAA.click();
        } else if (company.contains("BBB")) {
            companyBBB.click();
        } else {
            throw new IllegalArgumentException("Invalid company name: " + company);
        }
    }

    public void selectTheRole(String role) {
        Select select = new Select(this.role);
        select.selectByVisibleText(role);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setCellPhone(String contactNo) {
        this.cellPhone.sendKeys(contactNo);
    }

    public void addTheUser() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }

}
