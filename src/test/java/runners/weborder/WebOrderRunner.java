package runners.weborder;
//Runner class is a way to run your all feature files from here
//Runwith annotation comes from Junit and it executes the feature files steps
//@CucumberOptions is a special annotation that have some keywords
//feature: this is the location of feature file  which comes from --> Path From Content Root
//glue: this is the location of step definitions which comes from  --> Path From Source Root
//dryRun: this is the way to get snips without executing the whole implementations
//it means if you make it true, you will immediately unimplemented snips

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class) //there are different frameworks
@CucumberOptions(

        features = "src/test/resources/features/com.weborder", //this is path for feature files
        glue = "stepdefinitions/webordersteps", //this is path for step definitions
        dryRun = false,
        tags = "@negative"

)



public class WebOrderRunner {
}
