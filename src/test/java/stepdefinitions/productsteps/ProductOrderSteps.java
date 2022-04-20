package stepdefinitions.productsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.productspages.ProductLoginPage;
import pages.productspages.ProductMainPage;
import pages.productspages.ProductOrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductOrderSteps {

    WebDriver driver = DriverHelper.getDriver();
    //WebDriver driver = new ChromeDriver();
    ProductLoginPage productLoginPage = new ProductLoginPage(driver);
    ProductMainPage productMainPage = new ProductMainPage(driver);
    ProductOrderPage productOrderPage = new ProductOrderPage(driver);



    @Given("The user navigates to the products website homepage and click orderButton")
    public void the_user_navigates_to_the_products_website_homepage_and_click_order_button() throws InterruptedException {
        //productLoginPage.login("Tester","test");
        productLoginPage.login(ConfigReader.readProperty("productusername"),
                ConfigReader.readProperty("productpassword"));

        productMainPage.clickOrderButton();
    }









    @When("The user enters the product information {string} and {string}")
    public void the_user_enters_the_product_information_and(String productName, String quantity) {

       productOrderPage.sendProductInfo(productName, quantity);


    }
    @When("The user enters the address information {string}, {string},{string}, {string},{string}")
    public void the_user_enters_the_address_information(String customerName, String street, String city, String state, String zip) {

        productOrderPage.sendAddressInformation(customerName,street,city,state,zip);

    }
    @When("the user enters the card information {string},{string}, {string}")
    public void the_user_enters_the_card_information(String cardType, String cardNumber, String expireDate) {
        productOrderPage.selectCartType(cardType);
        productOrderPage.sendPaymentInformation(cardNumber,expireDate);
        productOrderPage.clickProcessButton();
    }

    @Then("the user validates the success message")
    public void the_user_validates_the_success_message() {

       // productOrderPage.clickProcessButton();
        Assert.assertEquals("New order has been successfully added.", productOrderPage.getSuccessMessage());

    }



    @Then("the user validates product details  {string}, {string},{string}, {string},{string}, {string},{string}, {string},{string}, {string}")
    public void the_user_validates_product_details(String customerName, String productName, String quantity, String street, String city, String state, String zip, String cardType, String cardNumber, String expireDate) {

       productMainPage.clickviewallorders();
       productOrderPage.getinfo(customerName,productName,quantity,street,city,state,zip,cardType,cardNumber,expireDate);

    }



}
