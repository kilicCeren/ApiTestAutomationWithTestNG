package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {

    @Test
    public void get01() {
        //https://restful-booker.herokuapp.com/booking/10 url’ine
        // bir GET request gonderdigimizde donen Response’u yazdirin.

        // 1- Request body  ve end-point hazirlama

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirlama
        // Bu bir GET sorgusu body boş, expected data yok.

        // 3- Request gonderip,donen response'i kaydetme

        /*
        NOT : IntelliJ’de API sorgulari yapmak icin io.restasurred kutuphanesi kullanilir ve Response
        class’indan bir obje olusturmamiz gerekir
                Response response = given( ).when( ).get(url);
        Response olustururken kullandigimiz
                    given : Testimize baslarken bize verilen baslangic degerlerini ifade eder
                    when : Testimizde gerceklestirdigimiz islemleri ifade eder
                    then : Response degerlerini degerlendirmek icin yapilan islemleri ifade eder
                    and : Birbirine bagli islemleri ifade eder
         */

        Response response = given().when().get(url);
        response.prettyPrint(); // Body'i yazdirir

        // 4- Assetion
        // Requirment'ta herhangi bir assertion yok.

    }
}
