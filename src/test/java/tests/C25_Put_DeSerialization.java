package tests;

import testDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_DeSerialization extends BaseUrlJsonPlaceholder {


    @Test
    public void test01() {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip
    bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }
       Expected Response Body :
            {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
            }
     */

        // 1- endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);


        //RequestBody'sini Map olarak olusturalim.

        Map<String, Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap();
        System.out.println("request body : " + requestBodyMap);


        // 2- expected data olustur

        Map<String, Object> expectedData = TestDataJsonPlaceholder.bodyOlusturMap();

        // 3- request gonder ve donen response'i kaydet

        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .put("{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        //    expected Response body  <=====> response
        //        Map                         Response

        // Assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (De-Serialization)
        Map<String, Object> responseMap = response.as(HashMap.class);
        System.out.println("Response map : " + responseMap);

        // expectedData (Map) <===> responseMap(Map)

        assertEquals(expectedData.get("title"), responseMap.get("title"));
        assertEquals(expectedData.get("body"), responseMap.get("body"));
        assertEquals(expectedData.get("userId"), responseMap.get("userId"));
        assertEquals(expectedData.get("id"), responseMap.get("id"));


    }
}
