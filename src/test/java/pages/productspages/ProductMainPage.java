package pages.productspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductMainPage {


    public ProductMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Order']")
    private WebElement orderButton;  //linktext



    @FindBy(xpath = "//a[.='View all orders']")
    private WebElement viewallorders;



    public void clickOrderButton(){
       orderButton.click();
    }


    public void clickviewallorders(){
        viewallorders.click();
    }





}
