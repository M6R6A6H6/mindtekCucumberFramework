package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElarAddCompany;
import pages.ElarLoginPage;
import pages.ElarYardHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class elarAddCompanyTesting {
    WebDriver driver = Driver.getDriver();
    ElarYardHomePage elarYardHomePage = new ElarYardHomePage();
    ElarAddCompany elarAddCompany = new ElarAddCompany();
    List<Map<String, Object>> data = new ArrayList<>();
     ElarLoginPage elarLoginPage =new ElarLoginPage();



    @Given("User is on the login page of the application")
    public void user_is_on_the_login_page_of_the_application() {
        driver.get(ConfigReader.getProperty("ElarURL"));

    }
    @When("User enters login username {string} and password {string} and clicks sign in BTN")
    public void user_enters_login_username_and_password_and_clicks_sign_in_btn(String username, String password) {
       elarYardHomePage.loginInput.sendKeys(username);
       elarYardHomePage.passwordInput.sendKeys(password);
    }
    @Then("User is landed to the application page")
    public void user_is_landed_to_the_application_page() {
        elarYardHomePage.loginBtn.click();
    }
    @When("User clicks {string} btn")
    public void user_clicks_btn(String addCompanyBtn) {
       WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elarLoginPage.companyBtn));
        elarLoginPage.companyBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(elarAddCompany.addCompanyBtn));
       elarAddCompany.addCompanyBtn.sendKeys(addCompanyBtn);
    }
    @When("User validates Create company details:")
    public void user_validates_create_company_details(DataTable dataTable) {

       data = dataTable.asMaps(String.class, Object.class);

        for (Map<String, Object> datum : data) {
            elarAddCompany.nameInput.sendKeys(datum.get("Name").toString());
            elarAddCompany.MCnumber.sendKeys(datum.get("MC#").toString());
            elarAddCompany.DOTnumber.sendKeys(datum.get("DOT#").toString());
            elarAddCompany.phoneNumber.sendKeys(datum.get("Phone").toString());
            elarAddCompany.streetInput.sendKeys(datum.get("Street").toString());
            elarAddCompany.cityInput.sendKeys(datum.get("City").toString());
            elarAddCompany.stateInput.sendKeys(datum.get("State").toString());
            elarAddCompany.zipInput.sendKeys(datum.get("Zpi Code").toString());
            elarAddCompany.emailInput.sendKeys(datum.get("Email").toString());
            elarAddCompany.insuranceProducer.sendKeys(datum.get("Insurance(producer company name)").toString());
            elarAddCompany.producerPhoneNum.sendKeys(datum.get("Producer phone").toString());
            elarAddCompany.ProducerStreet.sendKeys(datum.get("Producer street").toString());
            elarAddCompany.producerCity.sendKeys(datum.get("Producer city").toString());
            elarAddCompany.ProducerState.sendKeys(datum.get("Producer state").toString());
            elarAddCompany.producerZipCod.sendKeys(datum.get("Producer zip code").toString());
            elarAddCompany.producerEmail.sendKeys(datum.get("Producer email").toString());
            elarAddCompany.empIdNum.sendKeys(datum.get("Employer id number").toString());

        }

    }
    @When("User clicks {string} button")
    public void user_clicks_button(String createCompBtn) {
        elarAddCompany.createCompBtn.sendKeys(createCompBtn);
    }
    @Then("User should see the created company")
    public void user_should_see_the_created_company() {

    }

}