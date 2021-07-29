package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        // To record the logs in file, first need to add  ".addFilter(RequestLoggingFilter.logRequestTo(stream))
        //               .addFilter(ResponseLoggingFilter.logResponseTo(stream))"    methods in the requestspec method and the create Printstream method
        //

        PrintStream stream = new PrintStream(new FileOutputStream("Logging.txt"));
        req = new RequestSpecBuilder().setBaseUri(properties("BaseURI"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .setContentType(ContentType.JSON).build();
        return req;
    }

    public static String properties(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\karthikk\\IdeaProjects\\Cucumber\\BDD_RestASSured\\src\\test\\java\\Resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }


}
