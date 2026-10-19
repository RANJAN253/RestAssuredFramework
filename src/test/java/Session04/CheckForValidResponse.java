package Session04;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidResponse {

    @Test
    public void getSingleUser() {
        //specify  base URL
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec = RestAssured.given();

        //call get method
        Response response = requestSpec.get();

        // Gets response code
        int statusCode = response.getStatusCode();

        // validate actualStatuscode with expected
        Assert.assertEquals(statusCode/*actual stattus code*/,200/*expected status code*/,"correct status code received");

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK", "Incorrect status line returned");
    }

    @Test
    public void getSingleUserValidatableResponse()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec = RestAssured.given();

        //call get method
        Response response = requestSpec.get();

        ValidatableResponse validateresponses = response.then();



    }
}
