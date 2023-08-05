package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;


public class ElarYardHomePage {
    WebDriver driver;

    public ElarYardHomePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;
    @FindBy(id = "id_input_pass")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn-login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//div[@id='app']/aside/nav/ul[3]/li[1]/a")
    public WebElement yardBtn;
    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addYardButton;
    @FindBy(id = "//input[@id='id_yard_location']")
    public WebElement aptName;
    @FindBy(id = "//input[@id = 'id_apt_suite_company_co']")
    public WebElement aptOrSuite;
    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement invalidInput;
}