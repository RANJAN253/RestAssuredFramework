package TestCases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserTest {
	
	@Test
	public void getUsers() {
		Response res = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		System.out.println("Status Code: " + res.getStatusCode());
		System.out.println("Response Body: ");
		System.out.println(res.getBody().asString());
		
		
		//Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		//System.out.println("Status Code: " + response.getStatusCode());
		//System.out.println("Response Body: ");
		//System.out.println(response.getBody().asString());
		}
}
