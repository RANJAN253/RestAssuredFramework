package S20_POJO;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerializationAndDeserilization {
    //Serialization - Convert employee class object to JSON Object
    //Deserialization - Reverse of serializing , Convert a JSON Object to Class Object

    @Test
    public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
        Employee emp= new Employee();
        emp.setFirstName("Ranjan");
        emp.setLastname("Kumar");
        emp.setGender("Male");
        emp.setAge(40);
        emp.setSalary(10000.00);

        //Convert employee class object to JSON payload as String
        ObjectMapper objmapper = new ObjectMapper();
        String employeejson = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        System.out.println(employeejson);

        //create Request Specification
        RequestSpecification requesSpec= RestAssured.given();

        requesSpec.baseUri("http://httpbin.org/post");
        requesSpec.contentType(ContentType.JSON);
        requesSpec.body(employeejson);

        //perform post request
        Response response = requesSpec.post();
        response.prettyPrint();

        //validate status code
        Assert.assertEquals(response.statusCode(),200,"check for status code");

        //Convert JSON String (employeeJSON) to class object (Employee)
        Employee emp2 = objmapper.readValue(employeejson, Employee.class);

        System.out.println("--------Print after SJON Object to class");
        System.out.println("FirstName : " +emp2.getFirstName());
        System.out.println("LastName : "+emp2.getLastname());
        System.out.println("Gender :" + emp2.getGender());
        System.out.println("Age : " + emp2.getAge());
        System.out.println("Salary : " + emp2.getSalary());

        //http://httpbin.org

    }

}
