package Session03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PatchMethod {

    @Test
    public void Test05() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("Name", "Sandeep");
        jsonData.put("Job", "Teacher");

        RestAssured.baseURI = "https://reqres.in/api/users/637";
        RestAssured.given().header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(jsonData.toJSONString()).
                when().
                patch().
                then().
                statusCode(200).log().all();
    }
}