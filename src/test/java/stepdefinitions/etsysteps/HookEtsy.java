package stepdefinitions.etsysteps;

import com.sun.tools.doclets.internal.toolkit.util.DocFinder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverHelper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HookEtsy {

    WebDriver driver = DriverHelper.getDriver();

    @Before
    public  void beforeScenario(){
        System.out.println("Before Scenario");
    }

    @After
    public void afterScenario(Scenario scenario){
        Date currentDate = new Date();
        String screenShotsFileName = currentDate.toString().replace(" ","-")
                .replace(":","-");

        if(scenario.isFailed()){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


            try {
                FileUtils.copyFile(screenshotFile, new File(new File("src/test/java/screenshot/" + screenShotsFileName) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        DriverHelper.tearDown();

    }


}
