package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {

    // bu soru GET ic ice data ile soft assert


    @Test
    public void test01() {
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
         bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
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


        // 1- endpoint ve request body hazirla
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";
        //Get requestte body gondermemize gerek yok

        // 2- expected data olustur
        JSONObject expectedData = new JSONObject();
        JSONObject dataBilgileriJson = new JSONObject();

        dataBilgileriJson.put("id", 3);
        dataBilgileriJson.put("employee_name", "Ashton Cox");
        dataBilgileriJson.put("employee_salary", 86000);
        dataBilgileriJson.put("employee_age", 66);
        dataBilgileriJson.put("profile_image", "");

        expectedData.put("status", "success");
        expectedData.put("data", expectedData);
        expectedData.put("message", "Successfully! Record has been fetched.");


        // 3- request gonder ve donen response'i kaydet
        Response response = given().when().get(url);

        //response.prettyPrint();


        // 4- Assertion


        // Oncelikle response uzerindeki bilgileri kolay almak icin
        //JsonPath'e cast edelim.

        JsonPath responseJsonpath = response.jsonPath();

        // TestNg Soft assertte once Actual, sonra expected.

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseJsonpath.get("status"), expectedData.get("status"));
        softAssert.assertEquals(responseJsonpath.get("message"), expectedData.get("message"));

        softAssert.assertEquals(responseJsonpath.get("data.id"),
                expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_name"),
                expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_salary"),
                expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonpath.get("data.employee_age"),
                expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonpath.get("data.profile_image"),
                expectedData.getJSONObject("data").get("profile_image"));


        softAssert.assertAll();


    }
}
