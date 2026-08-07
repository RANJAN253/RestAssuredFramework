package TestCases;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test_PutMethod {
	
	@Test
	public void Test04()
	{
		
	JSONObject jsondata = new JSONObject();
	jsondata.put("name", "Sandeep");
	jsondata.put("username", "mehto");
	
	//Base URI
	baseURI="https://jsonplaceholder.typicode.com/users/11";
	
	//Request
	given()
		.header("Content-Type", "application/json; charset=utf-8")
		.contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
	.when()
		.put()
	.then()
		.statusCode(200).log().all();
	
}

}
