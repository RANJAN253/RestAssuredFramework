package TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ValidateResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		 given()
	     .when()
	            .get("https://jsonplaceholder.typicode.com/users")
	     .then()
	            .statusCode(200)
	            .body("size()", greaterThan(0));
		
	    }
}
