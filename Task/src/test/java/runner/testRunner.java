package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/RegisterandLoginDemo.feature",glue = {"stepDefinition"},
        monochrome = true,
        //dryRun = true,
        plugin = {"pretty","html:test-output"}
)

public class testRunner {

}
