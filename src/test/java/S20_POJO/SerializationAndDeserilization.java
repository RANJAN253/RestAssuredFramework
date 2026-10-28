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

    //Create pojo class ofJSON Array Object Payload
    //Serialization & Deserialization


    // How to create POJO class  of JSON Array.

    // what is polo(Plain old java Object)
    /*Pojo is a class which used for object representation of structured Data(JSON). this class contains all the keys as nodes  and provides
    getters  and setters  to add the abstraction layer

    Advance
    for better readability
    Reusability
    Easy access to data

     */

    @Test
    public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
        Employee emp1= new Employee();
        emp1.setFirstName("Ranjan");
        emp1.setLastname("Kumar");
        emp1.setGender("Male");
        emp1.setAge(40);
        emp1.setSalary(10000.00);

        //Convert employee class object to JSON payload as String
        ObjectMapper objmapper = new ObjectMapper();
        String employeejson = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
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
    }

}
