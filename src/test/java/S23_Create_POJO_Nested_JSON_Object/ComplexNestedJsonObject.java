package S23_Create_POJO_Nested_JSON_Object;
import S22_CreateNestedPOJO.EmployeeAddress;
import S22_CreateNestedPOJO.EmployeePojoClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ComplexNestedJsonObject {

    @Test
    public void createUser() throws JsonProcessingException {
        Nested_Pojo_Json_Class requestpayload = new Nested_Pojo_Json_Class();

        requestpayload.setCompanyName("Transcend Infoysystem Pvt. Ltd");
        requestpayload.setCity("Noida");
        requestpayload.setState("UP");
        requestpayload.setPincode("201301");

        List<String> banks = new ArrayList<String>();
        banks.add("HDFC");
        banks.add("Axis");
        banks.add("SBI");
        requestpayload.setBankaccount(banks);

        EmployeePojoClass emp1 = new EmployeePojoClass();
        EmployeePojoClass emp2 = new EmployeePojoClass();
        EmployeePojoClass emp3 = new EmployeePojoClass();

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

        emp2.setFirstName("Suraj");
        emp2.setLastName("Kumar");
        emp2.setGender("Male");
        emp2.setAge("35");
        emp2.setSalary("40000");
        empaddress.setStreet("Madangir");
        empaddress.setCity("Saket");
        empaddress.setState("New Delhi");
        empaddress.setPincode("110065");
        emp2.setAddress(empaddress);

        emp3.setFirstName("Bimal");
        emp3.setLastName("Kumar");
        emp3.setGender("Male");
        emp3.setAge("35");
        emp3.setSalary("45000");
        empaddress.setStreet("Dhangal Dhauda");
        empaddress.setCity("Dhanbad");
        empaddress.setState("Jharkhand");
        empaddress.setPincode("123456");
        emp3.setAddress(empaddress);

        List<EmployeePojoClass> employees = new ArrayList<EmployeePojoClass>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        requestpayload.setEmployeeList(employees);

        //Convert class object to JSON Object as String
        ObjectMapper objmapper = new ObjectMapper();
        String payload = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestpayload);

        RequestSpecification requestSpec = RestAssured.given();

        //specify URL
        requestSpec.baseUri("https://httpbin.org/post");

        //specify content type and request payload
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(payload);
        Response  response = requestSpec.post();

        System.out.println("-----------response body------------");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200 ,"check status code");

       // System.out.println(payload);
    }
}