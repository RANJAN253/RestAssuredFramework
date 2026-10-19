package TestCases;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
public class PostRequestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String requestBody = "{ \"name\": \"Leanne Graham\", \"username\": \"Bret\" }";

	        given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	        .when()
	            .post("https://reqres.in/api/users")
	        .then()
	            .statusCode(201);
	    }
}
