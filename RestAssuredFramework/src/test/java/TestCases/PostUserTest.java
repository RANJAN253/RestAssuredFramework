package TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PostUserTest {
	
	@Test
	public void createUser() {
		
		String requestBody = "{ \"name\": \"Ranjan\", \"username\": \"Engineer\" }";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("https://jsonplaceholder.typicode.com/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ranjan"))
            .body("username", equalTo("Engineer"));
	}
}