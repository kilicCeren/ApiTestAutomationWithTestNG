package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    //https://restful-booker.herokuapp.com/booking/10 url’ine
    // bir GET request gonderdigimizde donen Response’un,
    //status code’unun 200,
    //ve content type’inin application/json; charset=utf-8,
    //ve Server isimli Header’in degerinin Cowboy,
    //ve status Line’in HTTP/1.1 200 OK
    //ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

    @Test
    public void test01() {

        // 1- gerekli body  ve end-point hazirlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected body olustur
        // 3- request gonder ve donenn response'i kaydet

        Response response = given().when().get(url);

        System.out.println(response.getBody().toString());
        // respode body yazdırmak istedigimizde toString bile desek yazadıramıyoruz
        // bunun icin prettyPrint()' i kullanmamız gerekir.
        System.out.println(response.prettyPrint());

        /*
        Olusturdugumuz response objesi ile kullanilabilecegimiz methodlar :
        response.prettyPrint : Response’u yazdirir
        response.getStatusCode( ) : Response’un status kodunu verir
        response.getHeaders( ) : Response’un tum basliklarini (headers) verir
        response.getHeader("Server") : Response’un istenen basliginin(header) degerini verir
        response.getContentType( ) : Response’un Content Type’ini verir
        response.getStatusLine( ) : Response’un Status Line degerini verir
        response.getTime( ) : Response’un gerceklesme suresini milisaniye olarak verir
         */

        System.out.println("status code : " + response.getStatusCode() +
                "\n Content type : " + response.contentType() +
                "\n Server Header degeri : " + response.getHeader("Server") +
                "\n Status Line : " + response.getStatusLine() +
                "\n Status Line : " + response.getTime() + "ms");
        // 4- Assertion

    }
}
