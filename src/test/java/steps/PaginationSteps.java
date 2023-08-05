package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ElarLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
public class PaginationSteps {
    WebDriver driver = Driver.getDriver();
    ElarLoginPage elarLoginPage = new ElarLoginPage();

    @When("Validating login functionality with valid credentials")
    public void validating_login_functionality_with_valid_credentials() {
        driver.get(ConfigReader.getProperty("ElarURL"));
    }

    @When("User log in with username {string} and password {string}")
    public void user_log_in_with_username_and_password(String username, String password) {
        elarLoginPage.loginBtn.sendKeys(username);
        elarLoginPage.passwordInput.sendKeys(password);
        elarLoginPage.loginBtn.click();
    }
    @Then("User is successfully logged in")
   public void user_is_successfully_logged_in() {

    }
//    @When("User needs to click pancake button")
//    public void user_need_to_click_pancake_button() {
//        elarLoginPage.pancakeBtn.click();
//    }

    @When("User clicks on companies it will show table")
    public void user_click_on_backpack_it_will_show_table() {
    elarLoginPage.companyBtn.click();
    }

    @Given("User on the table page")
    public void user_on_the_table_page() {

    }
    @When("user clicks the {string} pagination button")
    public void user_clicks_the_pagination_button(String string) {

    }
    @Then("User should be on the last page")
    public void user_should_be_on_the_last_page() {

    }
    @Then("all tags should be reset")
    public void all_tags_should_be_reset() {

    }


}
