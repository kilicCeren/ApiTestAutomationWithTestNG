package tests;

import testDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {

        /*
       https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip
       bir PUT request yolladigimizda
       donen response’in status kodunun 200,
       content type’inin “application/json; charset=utf-8”,
       Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }

         Expected Data :
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }
        */

        // 1- endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);

        JSONObject requestBody = TestDataJsonPlaceholder.responseJsonBodyOlustur(10, 70, "Ahmet", "Merhaba");

        // 2- expected data olustur

        JSONObject expectedData = TestDataJsonPlaceholder
                .responseJsonBodyOlustur(10,
                        70,
                        "Ahmet",
                        "Merhaba");

        // System.out.println(expectedData);

        //System.out.println(expectedData.toString());

        // 3- request gonder ve donen response'i kaydet

        Response response = given().contentType(ContentType.JSON).spec(specJsonPlaceholder)
                .when()
                .body(requestBody.toString())
                .put("{pp1}/{pp2}");

        //response.prettyPrint();

        // 4- Assertion
        JsonPath responseJsonPath = response.jsonPath();
        //response'JsonPath'e cast ettik.

        //  donen response’in status kodunun 200,

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.getStatusCode());

        //       content type’inin “application/json; charset=utf-8”,

        assertEquals(TestDataJsonPlaceholder.contentType, response.getContentType());

        //       Connection header degerinin “keep-alive”
        assertEquals(TestDataJsonPlaceholder.headerConnection, response.header("Connection"));


        //        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));


    }
}
