package com.bijay.springboot.cucumber.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ControllerStepDefinition {

    @Given("^Set a room service api (.+)$")
    public String setGetEndpoint(String url) {
      String getURL =  "http://localhost:8000/";
      return getURL;
    }

    @When("Get URL is called")
    public ResponseEntity<String> callGetMethod() {
        RestTemplate rt = new RestTemplate();
        String URL=  "http://localhost:8000/"+"rooms";
        ResponseEntity<String> response = rt.getForEntity(URL, String.class );
        return response;
    }

    @Then("^Receive valid 200 response$")
    public void getValidResponse() {
        Assert.assertEquals(200 , callGetMethod().getStatusCodeValue());
    }

    @And("^response should contain data$")
    public void getData(){
        Assert.assertEquals(true , callGetMethod().getBody().contains("B"));
    }
}
