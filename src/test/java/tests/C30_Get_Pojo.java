package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoDummyExampleData;
import pojos.PojoDummyExampleResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Get_Pojo extends BaseUrlDummyExample {


    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
                Response Body
                {
                    "status": "success",
                    "data": {
                        "id": 3,
                        "employee_name": "Ashton Cox",
                        "employee_salary": 86000,
                        "employee_age": 66,
                        "profile_image": ""
                        },
                    "message": "Successfully! Record has been fetched."
                }
     */

    @Test
    public void test01() {
        // 1- Request url ve body olustur
        specDummyExample.pathParams("pp1", "employee", "pp2", 3);

        // 2- Soruda varsa expected data olustur

        PojoDummyExampleData dataPojo =
                new PojoDummyExampleData(3, "Ashton Cox", 86000, 66, "");

        PojoDummyExampleResponse expectedResponseBodyPojo =
                new PojoDummyExampleResponse("success", dataPojo, "Successfully! Record has been fetched.");
        // 3 - Response olustur, request gonderip sonucu response'a ata

        Response response = given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");

        //response.prettyPrint();
        //System.out.println(expectedResponseBodyPojo);


        /*
        pojos.PojoDummyExampleResponse@41ffaeb8[
                status=success,
                data=pojos.PojoDummyExampleData@43f0c2d1[
                        id=3,
                        employeeName=Ashton Cox,
                        employeeSalary=86000,
                        employeeAge=66,
                        profileImage=],
                 message=Successfully! Record has been fetched.]

         */

        // 4- Assertion

        // expectedResponseBodyPojo (Pojo) <=====> Response
        // hazir ceviriciler attribute isimlerini degistirdiginden, response'i Pojo'ya convert edemedik

        // Bu durumda testimize devam etmek icin response'i Jsonpath'e cevirebiliriz
        // expectedResponseBodyPojo (Pojo) <=====> ResponseJsonPath

        JsonPath responseJP = response.jsonPath();


        assertEquals(expectedResponseBodyPojo.getMessage(), responseJP.getString("message"));
        assertEquals(expectedResponseBodyPojo.getStatus(), responseJP.getString("status"));

        assertEquals(expectedResponseBodyPojo.getData().getId(),
                responseJP.get("data.id"));
        assertEquals(expectedResponseBodyPojo.getData().getEmployeeName(),
                responseJP.get("data.employee_name"));
        assertEquals(expectedResponseBodyPojo.getData().getEmployeeAge(),
                responseJP.get("data.employee_age"));
        assertEquals(expectedResponseBodyPojo.getData().getEmployeeSalary(),
                responseJP.get("data.employee_salary"));
        assertEquals(expectedResponseBodyPojo.getData().getProfileImage(),
                responseJP.get("data.profile_image"));


    }
}
