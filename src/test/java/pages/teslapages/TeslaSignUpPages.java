package pages.teslapages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class TeslaSignUpPages {
    public TeslaSignUpPages (WebDriver driver){
        PageFactory.initElements(driver,this);
    }





    @FindBy(xpath = "//span[.='Menu']")
    private WebElement menuButton;



    @FindBy(xpath = "//span[.='Shop']")
    private WebElement shopButton;

//span[.='Sign In']

    @FindBy(xpath = "//span[.='Sign In']")
    private WebElement signIn;


    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;




    @FindBy(xpath = "//button[.='Continue']")
    private WebElement continueButton;


    @FindBy(xpath = "//input[@id='form-input-credential']")
    private WebElement password;


    @FindBy(id = "form-submit-continue")
    private WebElement signInButton;



    @FindBy(xpath = "//a[.='Charging']")
    private WebElement chargingSection;





    @FindBy(xpath = "//p[.='Please enter valid email address']")
    private WebElement message;

    public void background(){
        //menuButton.click();
        shopButton.click();
    }

    public void chargingSectionTesla(WebDriver driver){
        chargingSection.click();

    }

    public String  getMessage(){
      return   BrowserUtils.getTextMethod(message);

    }




    public void signUpTesla(String email, String password){
        menuButton.click();
        signIn.click();
        this.email.sendKeys(email);
        continueButton.click();
        this.password.sendKeys(password);
        signInButton.click();
    }

    public void signUpTeslaNeg(String email){
        menuButton.click();
        signIn.click();
        this.email.sendKeys(email);
        continueButton.click();
    }







}
