package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElarYardHomePage;
import utilities.ConfigReader;


import utilities.Driver;

public class elarYardSteps {
    WebDriver driver = Driver.getDriver();
    ElarYardHomePage elarYardHomePage = new ElarYardHomePage();

    @Given("User should  navigates to application")
    public void user_should_navigates_to_application() {
        driver.get(ConfigReader.getProperty("ElarURL"));

    }

    @When("logs in with username {string} and password {string}")
    public void logs_in_with_username_and_password(String username, String password) {
        elarYardHomePage.loginInput.sendKeys(username);
        elarYardHomePage.passwordInput.sendKeys(password);

    }

    @When("User clicks logged in")
    public void user_clicks_logged_in() {
        elarYardHomePage.loginBtn.click();
    }


    @Given("User clicks the Yard button")
    public void user_clicks_the_yard_button() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elarYardHomePage.yardBtn));

        elarYardHomePage.yardBtn.click();

    }


    @When("User clicks the Add Yard button")
    public void user_clicks_the_add_yard_button() {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(elarYardHomePage.addYardButton));

        elarYardHomePage.addYardButton.click();

    }

    @When("User enter Apt name {string}")
    public void user_enter_apt_name(String expectedAptName) {
//      WebDriverWait wait3 = new WebDriverWait(driver,10);
//      wait3.until(ExpectedConditions.elementToBeClickable(elarYardHomePage.aptName));
        elarYardHomePage.aptName.sendKeys(expectedAptName);
    }

    @Then("User should see created  apt name  {string}")
    public void user_should_see_created_apt_name(String createdAptName) {

        Assert.assertEquals(elarYardHomePage.aptName.getAttribute("value"), createdAptName);

    }


    @When("User left Apt field empty")
    public void user_left_apt_field_empty() {
        elarYardHomePage.aptOrSuite.click();


    }

    @Then("website should allow  to create a yard without apt")
    public void website_should_allow_to_create_a_yard_without_apt() {
        boolean isAptFieldEnable = elarYardHomePage.aptOrSuite.isEnabled();
        Assert.assertFalse("Apt field should be disabled ", isAptFieldEnable);
    }

    @When("User enter {string} in the city field")
    public void user_enter_in_the_city_field(String cityField) {
//        WebDriverWait wait3 = new WebDriverWait(driver,10);
//        wait3.until(ExpectedConditions.elementToBeClickable(elarYardHomePage.aptOrSuite));
        elarYardHomePage.aptOrSuite.sendKeys(cityField);
    }


    @Then("The city field should contain {string}")
    public void the_city_field_should_contain(String expectedCity) {
        Assert.assertEquals(elarYardHomePage.aptOrSuite.getAttribute("value"), expectedCity);

    }


    @When("User type  {string} in the City field")
    public void user_type_in_the_city_field(String negativeInput) {
        elarYardHomePage.aptOrSuite.sendKeys(negativeInput);

    }


    @Then("The city should show an error message {string}")
    public void the_city_should_show_an_error_message(String expectedInput) {
        Assert.assertEquals(elarYardHomePage.invalidInput.getText(), expectedInput);
    }

    @When("USer select {string} from the States field")
    public void u_ser_select_from_the_states_field(String string) {

    }


    @Then("the states field should contain {string}")
    public void the_states_field_should_contain(String string) {

    }

//   @When("User enter {string} in the Zip field")
//    public void user_enter_in_the_zip_field(String) {
//        // Write code here that turns the phrase above into concrete actions
//
//  }


    @Then("the Zip field should contain {string}")
    public void the_zip_field_should_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enter {string} in the zip field")
    public void user_enter_in_the_zip_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("the Zip field should show an error message {string}")
    public void the_zip_field_should_show_an_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}


