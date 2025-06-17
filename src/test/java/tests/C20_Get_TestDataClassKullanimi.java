package tests;

import testDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response’in status kodunun 200
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }
         */

        // 1- endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 22);

        // 2- expected data olustur

        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur22();

        //System.out.println(expectedData.toString());

        // 3- request gonder ve donen response'i kaydet

        Response response = given().spec(specJsonPlaceholder)
                .when()
                .get("{pp1}/{pp2}");

        //response.prettyPrint();

        // 4- Assertion

        // donen response’in status kodunun 200
        //        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        JsonPath responseJsonPath = response.jsonPath();
        //response'JsonPath'e cast ettik.

        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.getStatusCode());
        Assert.assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));


    }
}
