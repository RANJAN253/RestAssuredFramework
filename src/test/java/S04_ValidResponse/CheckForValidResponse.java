package S04_ValidResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidResponse {

    @Test(enabled = false)
    public void getSingleUser() {
        //specify  base URL
        baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec = given();

        //call get method
        Response response = requestSpec.get();

        // Gets response code
        int statusCode = response.getStatusCode();

        // validate actualStatuscode with expected
        Assert.assertEquals(statusCode/*actual stattus code*/, 200/*expected status code*/, "correct status code received");

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line returned");
    }

    @Test(enabled = false)
    public void getSingleUserValidatableResponse() {
        baseURI = "https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec = given();

        //call get method
        Response response = requestSpec.get();

        ValidatableResponse validateRes = response.then();

        validateRes.statusCode(200);
        // validateRes.assertThat().statusCode(200);

        validateRes.assertThat().statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getSingleUser_BDDSttyle() {
        given()

                .when()
                .get("https://reqres.in/api/users/2")

                .then().statusCode(200).statusLine("HTTP/1.1 200 OK");
    }
}