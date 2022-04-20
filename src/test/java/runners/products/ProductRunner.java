package runners.products;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/com.products",
        glue = "stepdefinitions/productsteps",
        dryRun = false,
        tags = "@productproject",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)


public class ProductRunner {
}
