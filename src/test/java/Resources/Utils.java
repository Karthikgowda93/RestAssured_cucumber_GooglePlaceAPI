package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {

    // we have to make static because if we want the parameter to remain same across all the test case and do not change everytime
    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        // To record the logs in file, first need to add  ".addFilter(RequestLoggingFilter.logRequestTo(stream))
        //               .addFilter(ResponseLoggingFilter.logResponseTo(stream))"    methods in the requestspec method and the create Printstream method
        // to make the Logging not replace the previous data just add the condition
        if(req==null) {
            PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(properties("BaseURI"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
            }
        return req;
    }

    public static String properties(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\karthikk\\IdeaProjects\\Cucumber\\BDD_RestASSured\\src\\test\\java\\Resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response,String key){

        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return  js.get(key).toString();

    }


}
