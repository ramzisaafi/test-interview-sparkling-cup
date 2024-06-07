package com.sparklingcup;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber.json"},
    features = "classpath:com/sparklingcup/features",
    glue="com.sparklingcup.steps"
)
public class RunCucumberTest {
}


