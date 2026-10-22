package S03_Method_GET_PUT_POST_DEL;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_DeleteMethod {

    @Test
    public void Test06() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("Name", "Sandeep");
        jsonData.put("Job", "Teacher");

        RestAssured.baseURI = "https://reqres.in/api/users/637";
        RestAssured.given().
                when().
                    delete().
                then().
                    log().all().
                    statusCode(204);
    }
}
