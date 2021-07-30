package Resources;

import pojo.GoogleApiproduct;
import pojo.UpdateProductPayload;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class testJSONPayload {

    public GoogleApiproduct testData(String name, String Phone_number, String address, String language){

        GoogleApiproduct gap = new GoogleApiproduct();
        gap.setAccuracy(50);
        gap.setName(name);
        gap.setPhone_number(Phone_number);
        gap.setAddress(address);
        gap.setWebsite("http://google.com");
        gap.setLanguage(language);
        List<String> typeList = new ArrayList<String>();
        typeList.add("shoe park");
        typeList.add("shop");
        gap.setTypes(typeList);
        location l = new location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        gap.setLocation(l);

        return gap;
    }

    public String deleteApiPayload(String place_Id){
        return "{\r\n\r\n    \"place_id\": \""+place_Id+"\"\r\n\r\n}\r\n";
    }

    public UpdateProductPayload updatePlacePayload(String place_id, String address, String key){
        UpdateProductPayload up = new UpdateProductPayload();
        up.setPlace_id(place_id);
        up.setAddress(address);
        up.setKey(key);

        return up;
    }



}
