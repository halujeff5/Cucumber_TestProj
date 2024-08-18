package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/Feature/DevLabsScenarioOutline.feature" , glue = "StepDefinition" ,
// tags = "@smoke and not @e2e",

 //       tags = "@smoke and @e2e",

        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"}

)
public class Runner {


}
