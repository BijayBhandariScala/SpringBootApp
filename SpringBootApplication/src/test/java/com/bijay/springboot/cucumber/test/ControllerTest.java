package com.bijay.springboot.cucumber.test;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources" , plugin = {"pretty", "html:target/cucumber"})
public class ControllerTest {

}
