package runners.tesla;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/com.tesla",
        glue = "stepdefinitions/teslasteps",
        dryRun = false,
        tags = "@tesla",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)





public class TeslaRunner {
}
