package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }
    @When("User searches {string}")
    public void user_searches(String itemName) {
        etsyHomePage.searchBar.sendKeys(itemName + Keys.ENTER);
    }

    @Then("User Validates search result contains")
public void user_validates_search_result_contains(DataTable data) {

        List<String> keywords = data.asList();
        for (WebElement item : etsyHomePage.itemDescriptions) {
            String itemDiscription = item.getText();
            boolean isFound = false;
            String wordFound = "";
            for (int i = 0; i < keywords.size(); i++) {
                if (itemDiscription.toLowerCase().contains(keywords.get(i))) {
                    isFound = true;
                } else {
                    wordFound = keywords.get(i);
                }
            }
            Assert.assertTrue("[" + itemDiscription + "] does not contain keyword: " + wordFound, isFound);
        }
    }

    @When("User selects price range over {double}")
    public void user_selects_price_range_over(Double priceRange) {
        etsyHomePage.allFilterBtn.click();
        etsyHomePage.over1000Btn.click();
        etsyHomePage.applyBtn.click();
    }
    @Then("User Validates price range for items over {double}")
    public void user_validates_price_range_for_items_over(Double priceRange) {
       driver.navigate().refresh();
        for (WebElement price : etsyHomePage.price) {
            System.out.println(price.getText());
            Double priceDouble = Double.parseDouble(price.getText().replace(",", ""));
            Assert.assertTrue(priceDouble + "is less than" + priceRange, priceDouble >= priceRange);
        }
    }
    @When("User clicks on {string} module")
    public void user_clicks_on_module(String module) {
        switch (module) {
            case "Fashion Favorites":
                etsyHomePage.fashionFavoritesTab.click();
                break;
            case "Jewelry & Accessories":
                etsyHomePage.jewelryAccessoriesTab.click();
                break;
            case "Clothing & Shoes":
                etsyHomePage.clothingShoesTab.click();
                break;
            case "Home & Living":
                etsyHomePage.homeLiving.click();
                break;
            case "Wedding & Party":
                etsyHomePage.weddingPartyTab.click();
                break;
            case "Toys & Entertainment":
                etsyHomePage.toysEntertainment.click();
                break;
            case "Art & Collectibles":
                etsyHomePage.artCollectible.click();
                break;
            case "Craft Supplies":
                etsyHomePage.craftSuppliesTab.click();
                break;
            case "Gifts & Gift Cards":
                etsyHomePage.giftsGiftCardTab.click();
                break;
        }
    }

    @Then("User validates the {string} title")
    public void user_validates_the_title(String title) {
        Assert.assertEquals("Title is incorrect", title, driver.getTitle());

    }

}
