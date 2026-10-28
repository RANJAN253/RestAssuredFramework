package S22_CreateNestedPOJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NestedJsonPayload {

    @Test
    public void CreateUser() throws JsonProcessingException {

        EmployeePojoClass emp1 = new EmployeePojoClass();

        emp1.setFirstName("Ranjan");
        emp1.setLastName("Kumar");
        emp1.setGender("Male");
        emp1.setAge("40");
        emp1.setSalary("40000");


        EmployeeAddress empaddress = new EmployeeAddress();
        empaddress.setStreet("Bhagwan Nagar Chowk");
        empaddress.setCity("Ashram");
        empaddress.setState("New Delhi");
        empaddress.setPincode("110014");

        emp1.setAddress(empaddress);

        // convert class object to json object as string
        ObjectMapper objmapper = new ObjectMapper();

        String jsonpayload = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

        RequestSpecification requestSpec = RestAssured.given();

        //specify url
        requestSpec.baseUri("https://httpbin.org/post");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonpayload);

        //perform post request
        Response response = requestSpec.post();
        response.prettyPrint();

        //System.out.println(("Jsonpayload") +jsonpayload);
    }
}