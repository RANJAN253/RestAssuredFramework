package TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class AddFirstValidationPrograme {
	
	
	@Test
	public void validateUser() {
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/users")
		
		.then()
		.statusCode(200)
		.body("size()", greaterThan(0));
		
		
		
	}

}
