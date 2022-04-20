package pages.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {


    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    @FindBy(id = "ConfirmAddressID")
     WebElement deliveryOptions;

    @FindBy(xpath = "//label[@class='custom-control-label']")   ////input[@id='GroupOrder']
    WebElement groupOrderBox;

    @FindBy(id = "getAddressNextButton")
     WebElement nextButton;


    public void getDeliveryOption(String option){
        BrowserUtils.selectBy(deliveryOptions, option, "text");
    }


    public void clickGroupOrder(){
        groupOrderBox.click();
    }


    public void clickNextButton(){
        nextButton.click();
    }







}
