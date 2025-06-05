package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {

    // bu soru GET  response body employe List


    @Test
    public void test01() {

        /*
                http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
                status code'unun 200,
                ve content type'inin Aplication.JSON,
                ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu
                                                                        test edin.
         */

        // 1-  endpoint ve request body olustur

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- expected data olustur
        // 3- request gonder, donen response kaydet

        Response response = given().when().get(url);

        response.prettyPrint();


        //4- Assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 21, 35));


    }
}
