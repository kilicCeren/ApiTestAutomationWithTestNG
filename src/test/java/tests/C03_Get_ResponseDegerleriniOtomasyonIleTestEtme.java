package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonIleTestEtme {

    //https://restful-booker.herokuapp.com/booking/10 url’ine
    // bir GET request gonderdigimizde donen Response’un,
    //status code’unun 200,
    //ve content type’inin application/json; charset=utf-8,
    //ve Server isimli Header’in degerinin Cowboy,
    //ve status Line’in HTTP/1.1 200 OK

    @Test
    public void test02() {

        // 1- gerekli body  ve end-point hazirlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected body olustur
        // 3- request gonder ve donenn response'i kaydet
        Response response = given().when().get(url);

        // 4- Assertion

        response
                .then()
                .assertThat().statusCode(200)
                             .contentType("application/json; charset=utf-8")
                             .header("Server", "Heroku")
                             .statusLine("HTTP/1.1 200 OK");


    }
}
