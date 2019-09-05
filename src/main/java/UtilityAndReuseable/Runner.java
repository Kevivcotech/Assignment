package UtilityAndReuseable;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features/Test1.feature",
		glue = {"StepDefinitions"}
)
public class Runner {

}
