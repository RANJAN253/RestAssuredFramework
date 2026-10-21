package Session06;

import groovy.json.JsonParserType;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateJSONResponseBody {
    //JSON is a lightweight format for storing and transporting data
    //JSON is often used when data is sent from a server to a web page
    //JSON is "self-describing" and easy to understand

    /* JSON syntax Rules-
    /Data is name/value pairs
    Data is seperated by commas
    Curly brace hold objects
    Square brackets hold arrays
     */
// contains
    @Test
    public void UserListResponseBody()
    {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users?pages=2");

        //crate/perform get request
        Response response = requestSpec.get();

        //read response body
        ResponseBody responseBody = response.getBody();
        String responseString = responseBody.asString();
        System.out.println("Response body :" + responseString);

        // check for presence of Geoge in response body
        Assert.assertEquals(responseString.contains("George"),true,"Check for presence of Geogre");

        //get json  path view of response body

        JsonPath jsonpathview =  responseBody.jsonPath();

        //x.data[4].first_name
        String firstName = jsonpathview.get("data[0].first_name");

        System.out.println("email addres : "+ jsonpathview.get("data[1].avatar"));
        Assert.assertEquals(firstName,"George","Check for presence of firstname a George");
    }
}
