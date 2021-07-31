package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeDeletePlace() throws IOException {
// this class is to make the test independent like for ex in this case for deleteAPI to execute the
        stepDefinitions s = new stepDefinitions();

        if (stepDefinitions.place_id==null) {
            s.add_a_place_payload_with("Kings","(+91) 983 893 3937","29, side layout, cohen 09","Kannada");
            s.user_calls_the_using_post_http_request("AddPlaceAPI", "POST");
            s.verify_the_place_id_created_maps_to_from_the_api("Kings", "GetPlaceAPI");
        }
    }
    @Before("@UpdatePlace")
    public void beforeUpdatePlace() throws IOException {
// this class is to make the test independent like for ex in this case for deleteAPI to execute the
        stepDefinitions s = new stepDefinitions();

        if (stepDefinitions.place_id==null) {
            s.add_a_place_payload_with("Kings","(+91) 983 893 3937","29, side layout, cohen 09","Kannada");
            s.user_calls_the_using_post_http_request("AddPlaceAPI", "POST");
            s.verify_the_place_id_created_maps_to_from_the_api("Kings", "GetPlaceAPI");
        }
    }


}
