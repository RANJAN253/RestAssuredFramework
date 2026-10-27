package S05_ValidateResponseHeader;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseHeaderTest {

    @Test
    public void getSingleUser() {
        //Get  Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //specify base uri
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users/2");

        //create get request
        Response response = requestSpec.get();

        //validate response header
        String contentType = response.getHeader("Content-Type");
        System.out.println("value of connction: " + contentType);

        //read all the response header attributes/keys and print their values
        Headers headerList = response.getHeaders();

        //iterator over header list
        for (Header header : headerList) {
           System.out.println(header.getName() + ":" + header.getValue());
        }

        // validate header content-type , expected value : aapplication/json; charset=utf-8
        Assert.assertEquals(contentType,"application/json; charset=utf-8" ,"content Type missmatched");


    }
}


