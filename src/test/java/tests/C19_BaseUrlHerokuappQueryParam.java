package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class C19_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    /*
            Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

            1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu test edecek
            bir GET request gonderdigimizde,
            donen response’un status code’unun 200 oldugunu
            ve “Susan” ismine sahip en az bir booking oldugunu test edin

            2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametreleriniyazarak
            “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon oldugunu test edecek
            bir GET request gonderdigimizde,
            donen response’un status code’unun 200 oldugunu
            ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin
     */

    @Test
    public void test01() {
        //1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
        //            “firstname” degeri “Susan” olan rezervasyon oldugunu test edecek
        //            bir GET request gonderdigimizde,
        //            donen response’un status code’unun 200 oldugunu
        //            ve “Susan” ismine sahip en az bir booking oldugunu test edin


        // 1- endpoint ve request body olustur

        specHerokuapp
                .pathParam("pp1", "booking")
                .queryParam("firstname", "Susan");
        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        response.prettyPrint();
        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(greaterThanOrEqualTo(1)));


    }

    @Test
    public void test02() {
        //2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametreleriniyazarak
        //            “firstname” degeri “Susan” ve “lastname” degeri “Ericson” olan rezervasyon oldugunu test edecek
        //            bir GET request gonderdigimizde,
        //            donen response’un status code’unun 200 oldugunu
        //            ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin


        // 1- endpoint ve request body olustur

        specHerokuapp
                .pathParam("pp1", "booking")
                .queryParams("firstname", "Josh", "lastname", "Allen");
        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        response.prettyPrint();
        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(greaterThanOrEqualTo(1)));


    }
}
