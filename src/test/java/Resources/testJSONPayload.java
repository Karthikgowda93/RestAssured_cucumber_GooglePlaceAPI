package Resources;

import pojo.GoogleApiproduct;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class testJSONPayload {

    public GoogleApiproduct testData(){

        GoogleApiproduct gap = new GoogleApiproduct();
        gap.setAccuracy(50);
        gap.setName("Frontline house");
        gap.setPhone_number("(+91) 983 893 3937");
        gap.setAddress("29, side layout, cohen 09");
        gap.setWebsite("http://google.com");
        gap.setLanguage("French-IN");
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

}
