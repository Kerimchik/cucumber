package pages.weborderpages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class GroupOrderPage {

    public GroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "InviteNote")
    WebElement noteToInviteesTextarea;

    @FindBy(xpath = "//textarea[@id='InviteList']")
    WebElement inviteList;


    @FindBy(id = "createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(id = "addressPreview")
    WebElement officeAddress;

    @FindBy(tagName = "h1")
      WebElement headerText;

    @FindBy(xpath = "//label[.='Total Participants:']//following-sibling::div")
     WebElement totalParticipants;

    public void sendInviteNote(String invitationNotes){
       noteToInviteesTextarea.sendKeys(invitationNotes);
    }

    public void sendInviteList(String inviteList){
        this.inviteList.sendKeys(inviteList);  //it is parameter inside of the paranthesis
    }

    public String getofficeAddress(){
       return BrowserUtils.getTextMethod(officeAddress);
    }

    public void clickCreateButton(){
        createGroupOrderButton.click();
    }



    public String  getHeaderText() throws InterruptedException {
        Thread.sleep(1000);
        return BrowserUtils.getTextMethod(headerText);
    }

    public int getActualParticipantsNumber(){

        return Integer.parseInt(BrowserUtils.getTextMethod(totalParticipants));
    }





}
