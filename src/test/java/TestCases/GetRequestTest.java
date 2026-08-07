package TestCases;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");

	        System.out.println("Status Code: " + response.getStatusCode());
	        System.out.println("Response Body: " + response.getBody().asString());
	    }
}
