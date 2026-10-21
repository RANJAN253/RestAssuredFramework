package Session03;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_GetMethod {

    @Test
    public void test01()
    {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Response Code   : " + response.getStatusCode());
        System.out.println("Response Body   : " + response.getBody().asString());
        System.out.println("Response Time   : " + response.getTime());
        System.out.println("Response Header : " + response.getHeader("Content-Type"));

        //validate
        int expectstatuscode = 200;
        int Actualtatuscode = response.getStatusCode();

        Assert.assertEquals(expectstatuscode,Actualtatuscode);
    }

    @Test
    public void test02()
    {
        // given, When , then
        // RestAssured - Class
        //baseURI - Method
        // import static io.restassured.RestAssured.* ;   - for remove class name of RestAssured.

        //RestAssured.baseURI = "https://reqres.in/api/users";
        //RestAssured.given()

        baseURI = "https://reqres.in/api/users";
                 given()
                .queryParam("page", "2")
                .when().get()
                .then().statusCode(200);
    }

}



