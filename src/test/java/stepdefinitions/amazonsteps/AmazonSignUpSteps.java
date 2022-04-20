package stepdefinitions.amazonsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.amazonpages.AmazonSignUpPages;
import utils.DriverHelper;

import java.util.List;

public class AmazonSignUpSteps {

    WebDriver driver = DriverHelper.getDriver();
    AmazonSignUpPages amazonSignUpPages = new AmazonSignUpPages(driver);




    @When("the user clicks the sign in and create your amazon account button")
    public void the_user_clicks_the_sign_in_and_create_your_amazon_account_button() {

        driver.navigate().to("https://www.amazon.com/");
        amazonSignUpPages.setCreateAccount();

    }
    @Then("the user validate the header")
    public void the_user_validate_the_header(DataTable dataTable) {

        List<String> getHeader = dataTable.asList();
        Assert.assertEquals(getHeader.get(0),amazonSignUpPages.getHeadertext());

    }
    @Then("the user provides the information:")
    public void the_user_provides_the_information(DataTable dataTable) {

        List<String> allInformation = dataTable.asList();

        amazonSignUpPages.createAccount(allInformation.get(0),allInformation.get(1),allInformation.get(2),allInformation.get(3));


    }






}
