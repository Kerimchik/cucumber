package pages.openmrspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSLoginPage {


    public OpenMRSLoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Inpatient Ward")
    private WebElement inpatientWartButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;



    public void login(String username, String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        inpatientWartButton.click();
        loginButton.click();

    }






}
