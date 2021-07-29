package stepDefinitions;

import Resources.Utils;
import Resources.testJSONPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import pojo.GoogleApiproduct;
import pojo.location;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class stepDefinitions extends Utils {
  //  RequestSpecification req;
    ResponseSpecification res;
    RequestSpecification primary;
    Response response;
    testJSONPayload td = new testJSONPayload();


    @Given("Add a place payload With {string} {string} {string} {string}")
    public void add_a_place_payload_with(String name, String Phone_number, String address, String language) throws IOException {
         primary = given().spec(requestSpecification()).body(td.testData(name,Phone_number,address,language));
    }

    @When("user calls the {string} using Post http request")
    public void user_calls_the_using_post_http_request(String string) {
        res =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response =primary
                .when()
                .post("/maps/api/place/add/json")
                .then().spec(res).extract().response();

    }
    @Then("verify the api got success with status code {int}")
    public void verify_the_api_got_success_with_status_code(Integer int1) {
        Assertions.assertEquals(response.statusCode(), int1);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue,String expectedValue) {
        String resp = response.asString();
        JsonPath jp = new JsonPath(resp);
        System.out.println(jp.getString(keyValue));
     Assertions.assertEquals(jp.get(keyValue),expectedValue);

    }

}
