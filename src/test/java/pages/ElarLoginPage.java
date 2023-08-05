package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLoginPage {
    WebDriver driver;
    public ElarLoginPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(id = "id_input_pass")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn-login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//div[@class='button-aside']//*[name()='svg']")
    public WebElement pancakeBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/aside/nav/ul[3]/li[2]/a")
    public WebElement companyBtn;

}
