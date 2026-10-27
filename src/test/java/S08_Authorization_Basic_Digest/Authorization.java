package S08_Authorization_Basic_Digest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Authorization {

    @Test
    public void BasicAuth()
    {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://postman-echo.com");
        requestSpec.basePath("/basic-auth");

       //Response response = requestSpec.get();
       //Response response = requestSpec.auth().basic("postman","password").get();
        Response response = requestSpec.auth().preemptive().basic("postman","password").get();

        System.out.println("Response Status :" + response.statusLine());
        System.out.println("Response Body : "+ response.body().asString());
    }

    @Test
    public void DigestAuth()
    {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("http://httpbin.org");
        requestSpec.basePath("/digest-auth/undefined/ranjan/ranjan");

        //Response response = requestSpec.auth().basic("postman","password").get();
        Response response = requestSpec.auth().digest("ranjan","ranjan").get();

        Assert.assertEquals(response.statusCode()/*actual*/, 200, " check for status code");

        System.out.println("Digest Auth Response Status :" + response.statusLine());
        System.out.println("Digest Auth Body : "+ response.body().asString());
    }
}
