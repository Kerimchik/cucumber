package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OpenMRSRegisterNewPatient {

    public OpenMRSRegisterNewPatient(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "givenName")
    private WebElement givenName;

    @FindBy(name = "familyName")
    private WebElement familyName;

    @FindBy(id = "next-button")
    private WebElement nextButton;


    @FindBy(id = "gender-field")
    private WebElement selectGender;


    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    private WebElement day;

    @FindBy(xpath = "//select[@id='birthdateMonth-field']") //November
    private WebElement selectMonth;


    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    private WebElement year;


    @FindBy(id = "address1")
    private WebElement address;


    @FindBy(id = "cityVillage")
    private  WebElement city;



    @FindBy(id = "stateProvince")
    private  WebElement stateProvince;


    @FindBy(id = "country")
    private  WebElement country;


    @FindBy(id="postalCode")
    private  WebElement zip;


    @FindBy(xpath = "//input[@name='phoneNumber']")
    private  WebElement phoneNumber;


    @FindBy(id="relationship_type")
    private  WebElement relationshipType;


    @FindBy(xpath = "//input[@placeholder='Person Name']")
    private  WebElement personName;


    @FindBy(id="submit")
    private  WebElement confirmButton;


    public void sendName(String givenName, String familyName){
        this.givenName.sendKeys(givenName);
        this.familyName.sendKeys(familyName);
        nextButton.click();
    }


    public void sendGender(String gender){
        BrowserUtils.selectBy(selectGender, gender, "text");
        nextButton.click();
    }


    public void sendBirthdate(String day, String month, String year){
        this.day.clear();
        this.day.sendKeys(day);
        BrowserUtils.selectBy(selectMonth, month, "text");
        this.year.clear();
        this.year.sendKeys(year);
        nextButton.click();
    }


    public void sendAddress(String address){
       this.address.sendKeys(address);
       nextButton.click();
    }



    public void sendPhoneNumber(String number){
        this.phoneNumber.sendKeys(number);
        nextButton.click();
    }




    public void sendRelativeInfo(String relationType, String realtiveName){
        BrowserUtils.selectBy(relationshipType, relationType, "text");
        personName.sendKeys(realtiveName);
        nextButton.click();
    }



    public void clickConfirmButton(){
        confirmButton.click();
    }



    //rEsult page



    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    private WebElement validateGivenName;


    public String getGivenName(){
       return BrowserUtils.getTextMethod(validateGivenName);
    }




    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    private WebElement validateFamilyName;

    public String getFamilyName(){
        return BrowserUtils.getTextMethod(validateFamilyName);
    }




}
