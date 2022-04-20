package stepdefinitions.webordersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginPageSteps {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Before
    public void beforeScenario(){

        System.out.println("it runs before each scenario");
    }


    @After
    public void afterScenario(){


        System.out.println("it runs after each scenario");

    }


    @Given("the user navigates to the WebOrder website")
    public void the_user_navigates_to_the_web_order_website() {
        driver.navigate().to(ConfigReader.readProperty("weborderurl"));

    }
    @When("the user provides credentials")
    public void the_user_provides_credentials() {
        loginPage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));



    }
    @Then("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Assert.assertEquals(driver.getTitle(),"ORDER DETAILS - Weborder");
    }

    @When("the user provides correct username and wrong password")
    public void the_user_provides_correct_username_and_wrong_password() {

        loginPage.login(ConfigReader.readProperty("weborderusername"),"wrongPassword");
    }

    @Then("the user validate the {string} error message")
    public void the_user_validate_the_error_message(String expectedMessage) {
        Assert.assertTrue(loginPage.validateErrorMessage(expectedMessage));

    }

/*//for the second negative scenario with hard coding and people don't like it
    @When("the user provides wrong username and password")
    public void the_user_provides_wrong_username_and_password() {


    }*/


 //if we put in string in features it will be using parameter and make it fully dynamic
    @When("the user provides wrong {string} and {string}")
    public void the_user_provides_wrong_and(String username, String password) {

        loginPage.login(username,password);

    }


    @When("the user provides empty {string} and {string}")
    public void the_user_provides_empty_and(String string, String string2) {
        loginPage.login("","");
    }



}
