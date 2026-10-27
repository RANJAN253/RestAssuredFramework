package S07_Query_Parameters;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueryParameterDemoTest {

    @Test
    public void filterData() {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");
        requestSpec.queryParam("page", 2).queryParam("id", 10);

        //perform get request
        Response response = requestSpec.get();
        String responseBodyString = response.getBody().asString();
        System.out.println("ResponseBody : " + responseBodyString);

        JsonPath jsonpathview = response.jsonPath();
        // get firs_name =  x.data.first_name
        String firstname = jsonpathview.get("data.first_name");
        Assert.assertEquals(firstname, "Byron", "Verify first name");
    }
}
