package pages.productspages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProductOrderPage {

    public ProductOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;


    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    private WebElement customerName;




    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox2")
    private WebElement street;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    private WebElement city;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox4")
    private WebElement state;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    private WebElement zip;


    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visaButton;


    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement masterCard;


    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement americanExpress;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox6")
    private WebElement cardnumber;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox1")
    private WebElement expireDate;



    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;


    @FindBy(tagName = "strong")
    private WebElement message;


    public void sendProductInfo(String product, String quantity){
        BrowserUtils.selectBy(this.productName, product,"value");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }



    public void sendAddressInformation(String customerName,String street, String city, String state, String zip){

        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }




    public void sendPaymentInformation(String cardNumber, String expireDate){

        this.cardnumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }


    public void selectCartType(String cardType){
        switch (cardType){
            case "Visa":
                visaButton.click();
                break;

            case "MasterCard":
                masterCard.click();
                break;

            case "American Express":
                americanExpress.click();
                break;
        }
    }

    public void clickProcessButton(){
        processButton.click();
    }

    public String getSuccessMessage(){
        return BrowserUtils.getTextMethod(message);
    }


    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    private List<WebElement> productInfo;


    public void getinfo(String customerName, String productName, String quantity, String street, String city,
                        String state, String zip, String cardType, String cardNumber, String expireDate){

        Assert.assertEquals(productInfo.get(1).getText().trim(), customerName);
        Assert.assertEquals(productInfo.get(2).getText().trim(), productName);
        Assert.assertEquals(productInfo.get(3).getText().trim(), quantity);
        Assert.assertEquals(productInfo.get(5).getText().trim(), street);
        Assert.assertEquals(productInfo.get(6).getText().trim(), city);
        Assert.assertEquals(productInfo.get(7).getText().trim(), state);
        Assert.assertEquals(productInfo.get(8).getText().trim(), zip);
        Assert.assertEquals(productInfo.get(9).getText().trim(), cardType);
        Assert.assertEquals(productInfo.get(10).getText().trim(), cardNumber);
        Assert.assertEquals(productInfo.get(11).getText().trim(), expireDate);



    }




}
