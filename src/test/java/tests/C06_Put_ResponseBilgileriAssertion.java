package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {

    @Test
    public void test01() {


        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine
         asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
                {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
                }
            donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve Server isimli Header’in degerinin cloudflare,
                ve status Line’in HTTP/1.1 200 OK
         */

        // 1- request body ve end-point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Ahmet");
        requestBody.put("body", "Merhaba");
        requestBody.put("userId", 10);
        requestBody.put("id", 70);

        // 2- expected body olustur

        // 3- request gonder ve donenn response'i kaydet
        Response response = given().contentType(ContentType.JSON)  //Bu bir PUT çağrsı bir body'si var
                // ve gönderecegimiz body formatini belirtmemeiz gerekir
                .when()
                .body(requestBody.toString()) //Gönderecegimiz body'mizi secmemiz gerekir
                // ve Json objesi ile calistigimiz icin String cevirdik
                .put(url);

        // API sorgularinda bizden  rsponselari yazdirmamizi istemezler sorgumuzu kontrol edip silmeliyiz.
        // Bizim icin onemli olan Assertions
        // response.prettyPrint();

        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
