package runners.products;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "target/uiFailedTests.txt",  //location of of the failedtests ---> content root
        glue = "stepdefinitions/productsteps",    //step definitions/sourse
        dryRun = false,
        tags = "  @productprojectOutline",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTests.txt"}


)






public class ProductReRun {
}
