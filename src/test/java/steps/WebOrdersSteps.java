package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrderHomePage;
import pages.WebOrderOrdersPage;
import pages.WebOrdersLoginPage;
import utilities.BrowserUtility;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
    WebOrderOrdersPage webOrderOrdersPage = new WebOrderOrdersPage();
    List<Map<String, Object>> data = new ArrayList<>();

    @Given("User navigates to application")
    public void user_navigates_to_application() {
        driver.get(ConfigReader.getProperty("WebOrdersUrl"));
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String userName, String password) {
        webOrdersLoginPage.usernameInput.sendKeys(userName);
        webOrdersLoginPage.usernamePassword.sendKeys(password);
        webOrdersLoginPage.loginBtn.click();
    }

@Then("User is successfully logged in and  land on the home page")
public void user_is_successfully_logged_in_and_land_on_the_home_page() {
    Assert.assertEquals("Web Orders", driver.getTitle());
}

    @Then("User validates error messages {string}")
    public void user_validates_error_messages(String invalidCredential) {
        Assert.assertEquals(invalidCredential, webOrdersLoginPage.errorMsg.getText());
    }


@When("User clicks on  Order tab")
public void user_clicks_on_order_tab() {
    webOrderHomePage.orderTab.click();
}

    @When("User selects product {string} and quantity {int}")
    public void user_selects_product_and_quantity(String  product, Integer quantity ) {
       BrowserUtility.selectDropdownByValue(webOrderOrdersPage.productDropdown, product);
       webOrderOrdersPage.quantityInput.sendKeys(Keys.BACK_SPACE + quantity.toString());
       webOrderOrdersPage.calculateBtn.click();
//
    }


    @Then("User validates the price is correctly calculated for  {int}")
    public void user_validates_the_price_is_correctly_calculated_for(Integer quantity ) {
        int priceInt = Integer.parseInt(webOrderOrdersPage.pricePerUnit.getAttribute("value"));

        int discountInt = Integer.parseInt(webOrderOrdersPage.discount.getAttribute("value"));
        int expectedTotal;
        if (quantity >= 10) {
            expectedTotal = quantity * priceInt * (100 - discountInt) / 100;

        } else {
            expectedTotal = priceInt * quantity;
        }
        int actualTotal = Integer.parseInt(webOrderOrdersPage.total.getAttribute("value"));

        Assert.assertEquals(expectedTotal, actualTotal);
    }

    @When("User creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
    data = dataTable.asMaps(String.class, Object.class);
        for (int i = 0; i < data.size(); i++) {
            BrowserUtility.selectDropdownByValue(webOrderOrdersPage.productDropdown, data.get(i).get("PRODUCT").toString());
            webOrderOrdersPage.quantityInput.sendKeys(Keys.BACK_SPACE + data.get(i).get("QUANTITY").toString());
            webOrderOrdersPage.inputName.sendKeys(data.get(i).get("CUSTOMER NAME").toString());
            webOrderOrdersPage.inputStreet.sendKeys(data.get(i).get("STREET").toString());
            webOrderOrdersPage.inputCity.sendKeys(data.get(i).get("CITY").toString());
            webOrderOrdersPage.inputState.sendKeys(data.get(i).get("STATE").toString());
            webOrderOrdersPage.inputZip.sendKeys(data.get(i).get("ZIP").toString());
            webOrderOrdersPage.visaCardBtn.click();
            webOrderOrdersPage.inputCardNum.sendKeys(data.get(i).get("CARD NUM").toString());
            webOrderOrdersPage.inputExpDate.sendKeys(data.get(i).get("EXP DATA").toString());
            webOrderOrdersPage.processBtn.click();
            user_validates_success_message("New order has been successfully added.");

        }

    }

//    @Then("User validates success message {string}")
//    public void user_validates_success_message(String expectedMessage) {
//        Assert.assertEquals(expectedMessage, webOrderOrdersPage.successMessage.getText());
@Then("User Validates success message {string}")
public void user_validates_success_message(String expectedMessage) {
    Assert.assertEquals(expectedMessage, webOrderOrdersPage.successMessage.getText());

}

    @Then("User validates created order is in the list of all orders.")
    public void user_validates_created_order_is_in_the_list_of_all_orders() {
        webOrderHomePage.viewAllOrdersTab.click();
    Assert.assertEquals(data.get(1).get("CUSTOMER NAME").toString(),
            webOrderHomePage.firstRowOrder.get(1).getText());





    }


}
