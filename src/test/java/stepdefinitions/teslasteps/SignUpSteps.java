package stepdefinitions.teslasteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.teslapages.TeslaSignUpPages;
import utils.DriverHelper;

public class SignUpSteps {



    WebDriver driver = DriverHelper.getDriver();
    TeslaSignUpPages teslaSignUpPages = new TeslaSignUpPages(driver);


    @When("the user clicks Shop button and clicks Charging")
    public void the_user_clicks_shop_button_and_clicks_charging() {
      teslaSignUpPages.background();
    }
    @Then("validate that the user is on the right page where title is {string}")
    public void validate_that_the_user_is_on_the_right_page_where_title_is(String string) {
       teslaSignUpPages.chargingSectionTesla(driver);
        Assert.assertEquals(string, driver.getTitle());
    }






    @When("the user clicks on shop, and clicks on menu, and the sign in buttons")
    public void the_user_clicks_on_shop_and_clicks_on_menu_and_the_sign_in_buttons() {
        teslaSignUpPages.background();
    }
    @Then("the user enters its {string} and {string}")
    public void the_user_enters_its_and(String email, String password) {
      teslaSignUpPages.signUpTesla( email,password);
    }


    @When("the user enters its wrong email {string}")
    public void the_user_enters_its_wrong_email(String string) {
        teslaSignUpPages.signUpTeslaNeg(string);
    }


    @Then("validate the message {string}")
    public void validate_the_message(String string) {
        Assert.assertEquals(string, teslaSignUpPages.getMessage());
    }












}
