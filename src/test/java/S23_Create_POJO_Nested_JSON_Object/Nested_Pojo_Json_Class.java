package S23_Create_POJO_Nested_JSON_Object;

import S22_CreateNestedPOJO.EmployeePojoClass;

import java.util.List;

public class Nested_Pojo_Json_Class {

    // How To Create JSON Object using POJO Class
    /*
   "employee" : [
    {
    "firstName" : "Ranjan",
    "lastName" : "Kumar",
    "Gender" : "Male",
    "Salary" : 45000,
    "Address" : {
                "Street" : "Bhagwan Nagar Chowk",
                "City"  :  "Ashram",
                "State" :  "New Delhi",
                "Pincode" : 110014
                }
    }

      {
    "firstName" : "Suraj",
    "lastName" : "Kumar",
    "Gender" : "Male",
    "Salary" : 55000,
    "Address" : {
                "Street" : "Madangir",
                "City"  :  "Saket",
                "State" :  "New Delhi",
                "Pincode" : 110065
                }
    }
    ]
     */
    private String companyName;
    private String Street;
    private String City;
    private String state;
    private String pincode;
    private List<String> bankaccount;
    private List<EmployeePojoClass> employeeList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public List<String> getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(List<String> bankaccount) {
        this.bankaccount = bankaccount;
    }

    public List<EmployeePojoClass> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeePojoClass> employeeList) {
        this.employeeList = employeeList;
    }
}
