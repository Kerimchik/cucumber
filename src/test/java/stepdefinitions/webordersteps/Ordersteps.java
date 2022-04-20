package stepdefinitions.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderpages.GroupOrderPage;
import pages.weborderpages.LoginPage;
import pages.weborderpages.OrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class Ordersteps {
     WebDriver driver = DriverHelper.getDriver();
     LoginPage  loginPage = new LoginPage(driver);
     OrderPage orderPage = new OrderPage(driver);
     GroupOrderPage groupOrderPage = new GroupOrderPage(driver);

    @Given("the user is on weborder homepage")
    public void the_user_is_on_weborder_homepage() {
       driver.navigate().to(ConfigReader.readProperty("weborderurl"));
        loginPage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @When("the user selects {string}")
    public void the_user_selects(String expectedDeliveryOption) {

        orderPage.getDeliveryOption(expectedDeliveryOption);

    }
    @When("the user is on the groupOrderPage")
    public void the_user_is_on_the_group_order_page() {
        orderPage.clickGroupOrder();
        orderPage.clickNextButton();
        Assert.assertEquals(driver.getTitle(), "Create Group Order - Weborder");
    }



    @When("the user sends ivitees notes {string}")
    public void the_user_sends_ivitees_notes(String inviteNote) {
       groupOrderPage.sendInviteNote(inviteNote);
    }


    @When("the user sents invite list {string} and {string}")
    public void the_user_sents_invite_list_and(String email1,String email2 ) {
        groupOrderPage.sendInviteList(email1+ "," +email2);
    }


    @Then("the user validates the {string} address")
    public void the_user_validates_the_address(String expectedAddress) {
        Assert.assertTrue(groupOrderPage.getofficeAddress().contains(expectedAddress));
    }


    @Then("the user validate {string} text")
    public void the_user_validate_text(String expectedText) throws InterruptedException {

        groupOrderPage.clickCreateButton();
        Assert.assertEquals(groupOrderPage.getHeaderText(),expectedText);

    }



    @Then("the user validates total participants is {int}")
    public void the_user_validates_total_participants_is(int expectedTotalParticipants) {

        Assert.assertEquals(groupOrderPage.getActualParticipantsNumber(), expectedTotalParticipants );
    }


}
