package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
         bir GET request gonderdigimizde
            donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                "firstname“in, "Mark",
                ve "lastname“in, "Brown",
                ve "totalprice“in, 1000'den kucuk oldugunu,
                ve "depositpaid“in, false,
                ve "additionalneeds“in, bos olmadigini
                                                    oldugunu test edin
         */

        // 1- request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected body olustur
        // 3- request gonder ve donenn response'i kaydet

        Response response = given().when().get(url);

        // 4- Assetion
        response.prettyPrint();
        /* Ikinci yontem ile yaptigimizda bu testimizdeki yazlianlar degismesin diye yoruma aldım.

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark"))
                .body("lastname", Matchers.equalTo("Brown"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(false))
                .body("additionalneeds",Matchers.notNullValue());

        */

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mark"),
                        "lastname", equalTo("Brown"),
                        "totalprice", Matchers.lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds", Matchers.notNullValue());

    }
}
