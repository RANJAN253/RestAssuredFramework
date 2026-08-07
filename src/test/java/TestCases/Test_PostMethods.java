package TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_PostMethods {
	
	@Test
	public void Test02()
	{
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "ranjan");
		jsondata.put("username", "QA");
		
		baseURI="https://jsonplaceholder.typicode.com/users";
		
		given()
			.header("Content-Type", "application/json; charset=utf-8")
			.contentType(ContentType.JSON)
			.body(jsondata.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(201).log().all();
		
	}

}
