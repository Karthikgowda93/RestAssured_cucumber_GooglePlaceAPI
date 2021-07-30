package stepDefinitions;

import Resources.APIResources;
import Resources.Utils;
import Resources.testJSONPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class stepDefinitions extends Utils {
  //  RequestSpecification req;
    ResponseSpecification res;
    RequestSpecification primary;
    Response response;
    testJSONPayload td = new testJSONPayload();
    // static because after the addplaceapi is excecuted it should be reset to null and will throws 404 error for place_id
    static String place_id;


    @Given("Add a place payload With {string} {string} {string} {string}")
    public void add_a_place_payload_with(String name, String Phone_number, String address, String language) throws IOException {


         primary = given().spec(requestSpecification()).body(td.testData(name,Phone_number,address,language));
    }

    @When("user calls the {string} using {string} http request")
    public void user_calls_the_using_post_http_request(String resources, String httpMethod) {

        // constructor will be called here as soon as the resource is defined in the feature file
        APIResources apiResource = APIResources.valueOf(resources);
        System.out.println(apiResource.getResource());

        res =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
       if(httpMethod.equalsIgnoreCase("POST"))
        response = primary.when().post(apiResource.getResource());
       else if(httpMethod.equalsIgnoreCase("GET"))
        response = primary.when().get(apiResource.getResource());
       else if(httpMethod.equalsIgnoreCase("PUT"))
        response = primary.when().put(apiResource.getResource());

    }
    @Then("verify the api got success with status code {int}")
    public void verify_the_api_got_success_with_status_code(Integer int1) {
        Assertions.assertEquals(response.statusCode(), int1);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue,String expectedValue) {

      //  System.out.println(jp.getString(keyValue));
     Assertions.assertEquals(getJsonPath(response,keyValue),expectedValue);

    }

    @Then("verify the place_id created maps to {string} from the {string} API")
    public void verify_the_place_id_created_maps_to_from_the_api(String expectedKey, String resource) throws IOException {

        place_id = getJsonPath(response,"place_id");
        primary = given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_the_using_post_http_request(resource, "GET");
        String actualKey = getJsonPath(response,"name");
   //   System.out.println(actualKey+" v/s "+expectedKey);
        Assertions.assertEquals(expectedKey,actualKey);

    }

    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {

        primary = given().spec(requestSpecification()).body(td.deleteApiPayload(place_id));

    }

    @Given("UpdatePlace request Payload with {string} {string}")
    public void update_place_request_payload(String address,String key) throws IOException {

        primary= given().spec(requestSpecification()).queryParam("place_id",place_id).body(td.updatePlacePayload(place_id,address,key));
//        System.out.println(response.asString());
    }



}
