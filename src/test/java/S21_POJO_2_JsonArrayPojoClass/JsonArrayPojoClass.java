package S21_POJO_2_JsonArrayPojoClass;

import S20_POJO.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class JsonArrayPojoClass {

    @Test
    public void createEmployeeJsonArray() throws JsonProcessingException {
        // create first employeeList
        Employee emp1 = new Employee();
        emp1.setFirstName("Ranjan");
        emp1.setLastname("Kumar");
        emp1.setGender("Male");
        emp1.setAge(40);
        emp1.setSalary(50000);

        // create 2nd employeeList
        Employee emp2 = new Employee();
        emp2.setFirstName("Sandeep");
        emp2.setLastname("Kumar");
        emp2.setGender("Male");
        emp2.setAge(35);
        emp2.setSalary(50000);

        // create 3rd employeeList
        Employee emp3 = new Employee();
        emp3.setFirstName("Suraj");
        emp3.setLastname("Kumar");
        emp3.setGender("Male");
        emp3.setAge(41);
        emp3.setSalary(50000);

        //Create list of Employee
        List<Employee> listofEmp = new ArrayList<Employee>();
        listofEmp.add(emp1);
        listofEmp.add(emp2);
        listofEmp.add(emp3);

        //Serialization - Convert employee class object to json array payload as String
        ObjectMapper objMapper = new ObjectMapper();
        String jsonarraypayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listofEmp);
        System.out.println("Employee class object to json array payload");
        System.out.println(jsonarraypayload);

        //Create Request Specification
        RequestSpecification requestSpec = RestAssured.given();

        //specify URL
        // requestSpec.baseUri("https://reqres.in/api/users"); OR
        requestSpec.baseUri("https://httpbin.org/post");

        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonarraypayload);

        //perform POST request
        Response response = requestSpec.post();
        System.out.println("-------------ResponseBody---------------");
        response.prettyPrint();

        //verify the status code
        Assert.assertEquals(response.statusCode(), 200, "Check for status code");

        // Convert too JsonArray  to Employee class object (Deserialization)

        ResponseBody responseBody = response.getBody();

        JsonPath jsonpathview = responseBody.jsonPath();

        List<Employee> allEmployees = jsonpathview.getList("json",Employee.class);

        System.out.println("-----------Response Body--------");

        for(Employee emp:allEmployees)
        {
            System.out.println(emp.getFirstName()+ " " +emp.getLastname());
        }

    }
}