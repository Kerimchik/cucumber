package pages.amazonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AmazonSignUpPages {

   public AmazonSignUpPages (WebDriver driver){
      PageFactory.initElements(driver,this);
   }





   @FindBy(id = "nav-link-accountList")
   private WebElement signInButton;



   @FindBy(id = "createAccountSubmit")
   private WebElement createAccountSubmit;


   @FindBy(id = "ap_customer_name")
   private WebElement customerName;



   @FindBy(id = "ap_email")
   private WebElement email;




   @FindBy(xpath = "//input[@name='password']")
   private WebElement password;




   @FindBy(xpath = "//input[@id='ap_password_check']")
   private WebElement passwordCheck;


   @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;


   @FindBy(tagName = "h1")
   private WebElement header;




   public void setCreateAccount(){

      signInButton.click();
      createAccountSubmit.click();

   }


   public String getHeadertext(){
      return BrowserUtils.getTextMethod(header);
   }





   public void createAccount(String customerName, String email, String password, String passwordCheck ){
      this.customerName.sendKeys(customerName);
      this.email.sendKeys(email);
      this.password.sendKeys(password);
      this.passwordCheck.sendKeys(passwordCheck);
   }












}
