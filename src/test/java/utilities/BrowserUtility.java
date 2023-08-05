package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

  public class BrowserUtility{
        /**
         * This method generators random emails
         * example: .getRandomEmail();--> returns xgiwpqw@
         */
        public  static  String getRandomEmail(){
            UUID uuid=UUID.randomUUID();
            return "user"+uuid+"@gmail.com";

        }
        /**
         * This method takes screenshots.
         * Ex:
         * .takeScreenshot("NAme of the screenshots");
         we should give name like as a parameter     */
        public static void takeScreenshots(String testName) throws IOException {
            WebDriver driver=Driver.getDriver();
            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path="src/test/resources/screenshots"+testName+" .png";
            File file=new File(path);
            FileUtils.copyFile(screenshot,file);

        }
        /**
         * This method accepts a web element and a string value to Select
         * an option from a dropdown by value (atribute value)
         * Ex:
         * .selectDropdownByValue(WebElement,String value);
         */
        public static void selectDropdownByValue(WebElement dropdown, String value){
            Select select = new Select(dropdown);
            select.selectByValue(value);

        }
        /**
         * This method will create a WebDriver wait object
         * and wait for certain text to be present in a WebElement
         * Ex:
         * .waitForTextToBePresentInElement(WebElement element, String expectedText):
         *
         */

        public static void waitForTextToBePresentInElement(WebElement element, String expectedText){
            WebDriverWait wait =new WebDriverWait(Driver.getDriver(),15);
            wait.until(ExpectedConditions.textToBePresentInElement(element,expectedText));
        }

        /**
         *
         * @param element
         */
        public static void waitForElementToBeClickable(WebElement element){
            WebDriverWait wait =new WebDriverWait(Driver.getDriver(),15);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        public static void scrollDownBy(Integer numOfPixel){
            JavascriptExecutor jse=((JavascriptExecutor) Driver.getDriver());
            jse.executeScript("window.scrollBy(0,"+numOfPixel);
        }
    }


