package S03_Method_GET_PUT_POST_DEL;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Test_PostMethod {

    @Test
    public void test03() {

        JSONObject jsonData = new JSONObject();
        jsonData.put("Name", "Ranjan");
        jsonData.put("Job", "Testing");

        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured.given().
                        header("Content-Type", "application/json").
                        contentType(ContentType.JSON).
                        body(jsonData.toJSONString()).
                    when().
                        post().
                    then().
                        statusCode(201).log().all();
    }
}
