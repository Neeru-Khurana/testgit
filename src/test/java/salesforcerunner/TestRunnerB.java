package salesforcerunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/Salesforce.feature"},
glue= {"salesforcesteps"})

public class TestRunnerB extends AbstractTestNGCucumberTests{

}
