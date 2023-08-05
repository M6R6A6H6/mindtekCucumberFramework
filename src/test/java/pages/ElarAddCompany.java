package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarAddCompany {
    WebDriver driver;
    public ElarAddCompany(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div[1]/div[3]/div[2]/a")
    public WebElement addCompanyBtn;
    @FindBy(xpath = "//*[@id=\"id_company_name\"]")
    public WebElement nameInput;
    @FindBy(xpath = "//*[@id=\"id_company_type\"]")
    public WebElement companyType;
    @FindBy(xpath= "//*[@id=\"id_status\"]")
    public WebElement status;
    @FindBy(id="//input[@id='id_mc_number']")
    public WebElement MCnumber;
    @FindBy(id = "//input[@id='c']")
    public WebElement DOTnumber;
    @FindBy(xpath = "//*[@id=\"id_ifta\"]")
    public WebElement IFTAinput;
    @FindBy(xpath = "//*[@id=\"add-company\"]/div[1]/div/div[3]/div[1]/p[1]/span/span/span[1]/input[1]")
    public WebElement phoneNumber;
    @FindBy(id="//input[@id='id_address']")
    public WebElement streetInput;
    @FindBy(xpath = "//*[@id=\"id_city\"]")
    public WebElement cityInput;
    @FindBy(xpath = "//*[@id=\"id_state\"]")
    public WebElement stateInput;
    @FindBy(xpath = "//*[@id=\"id_zip_code\"]")
    public WebElement zipInput;
    @FindBy(xpath = "//*[@id=\"add-company\"]/div[1]/div/div[3]/div[4]/p/span/span/span[1]/input")
    public WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"id_insurance\"]")
    public WebElement insuranceProducer;
    @FindBy(xpath = "//*[@id=\"add-company\"]/div[1]/div/div[4]/div[1]/p[1]/span/span/span[1]/input[1]")
    public WebElement producerPhoneNum;
    @FindBy(xpath = "//*[@id=\"id_producer_address\"]")
    public WebElement ProducerStreet;
    @FindBy(xpath = "//*[@id=\"id_producer_city\"]")
    public WebElement producerCity;
    @FindBy(xpath = "//*[@id=\"id_producer_state\"]")
    public WebElement ProducerState;
    @FindBy(xpath = "//*[@id=\"id_producer_zip_code\"]")
    public WebElement producerZipCod;
    @FindBy(xpath = "//*[@id=\"add-company\"]/div[1]/div/div[4]/div[3]/p/span/span/span[1]/input")
    public WebElement producerEmail;
    @FindBy(xpath = "//*[@id=\"id_employer_id_num\"]")
    public WebElement empIdNum;
    @FindBy(xpath = "//*[@id=\"id_other_licenses\"]")
    public WebElement otherLicenses;
    @FindBy(xpath = "//*[@id=\"add-company\"]/div[1]/div/div[10]/button")
    public WebElement createCompBtn;





}
