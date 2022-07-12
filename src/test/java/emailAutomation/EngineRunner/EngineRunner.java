package emailAutomation.EngineRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

tags = "@RunTest",

features = {"FeatureFiles"},  
glue = {"\\emailAutomation\\StepDefinition", "\\emailAutomation\\Hooks"}, 
dryRun= false)
public class EngineRunner extends AbstractTestNGCucumberTests {

	
}




