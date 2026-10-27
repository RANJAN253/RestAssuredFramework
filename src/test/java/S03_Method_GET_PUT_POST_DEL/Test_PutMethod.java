package S03_Method_GET_PUT_POST_DEL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PutMethod {

    @Test
    public void Test04() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("Name", "Sandeep");
       // jsonData.put("Job", "HR");

        RestAssured.baseURI = "https://reqres.in/api/users/637";
        RestAssured.given().header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(jsonData.toJSONString()).
                when().put().
                then().statusCode(200).log().all();
    }
}