package TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutUserTest {
	
	@Test
    public void updateUser() {

        String requestBody = "{ \"name\": \"Ranjan Updated\", \"job\": \"Senior QA\" }";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("https://jsonplaceholder.typicode.com/users")
        .then()
            .statusCode(200)
            .body("name", equalTo("Ranjan Updated"))
            .body("job", equalTo("Senior QA"));
	}
}
