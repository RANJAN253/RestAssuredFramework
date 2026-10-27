package S09_Authoriazation_Bearer_Token;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationDemoTest {

    @Test
    public void BearerToken() {
        //https://gorest.co.in/public/v2/users
        //create request specification

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://gorest.co.in");
        requestSpec.basePath("/public/v2/users");

        /*"name":"RanjanQA",
            "gender":"Male",
            "email":"ranjankmr25@gmail.com",
            "status":"Active"
         */

        JSONObject payload = new JSONObject();
        payload.put("name", "RanjanKumarPrasad");
        payload.put("gender", "male");
       // payload.put("email", "ranjankmr2512@gmail.com");
        payload.put("email", "ranjan" + System.currentTimeMillis()+ "@gmail.com");
        payload.put("status", "active");

        String authToken = "937b089c90c13df6f32e51123ed892a2bd5cbc693171f4ef9a5c816fc1774d65".trim();
        requestSpec.header("Authorization","Bearer " + authToken).
                contentType(ContentType.JSON).
                body(payload.toJSONString());

        //perform post request

        Response response = requestSpec.post();

        Assert.assertEquals(response.statusCode()/*actual*/, 201, " check for status code");

        System.out.println("Response Status Line :" + response.statusLine());
        System.out.println("Response Body : " + response.body().asString());
    }
}

