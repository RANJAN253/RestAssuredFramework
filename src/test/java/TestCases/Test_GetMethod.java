package TestCases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {

	@Test
	public void test01()
	{
		Response response = get("https://jsonplaceholder.typicode.com/users");
		System.out.println("Response Code : " + response.getStatusCode());
		System.out.println("Response Body : " + response.getBody().asString());
		System.out.println("Response Time : " + response.getTime());
		System.out.println("Response Header : " + response.getHeader("Content-Type"));
		
		//Validate Status code
		//expected status code = 200
		
		int expectedStatuscode = 200;
		int actualstatuscode = response.getStatusCode();
		
		Assert.assertEquals(expectedStatuscode, actualstatuscode);
	}
	
	@Test
	public void Test02()
	{
		//given, When , Then
		baseURI="https://jsonplaceholder.typicode.com/users";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
		
	}

}
