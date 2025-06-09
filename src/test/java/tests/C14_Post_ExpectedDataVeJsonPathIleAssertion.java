package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test01() {

        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde donen response’un
        id haric asagidaki gibi oldugunu test edin.

        POST REQUEST, RESPONSE BODY BILGILERINI ASSERT YAPARKEN JSONPATH KULLANMA
            Response Body
        {
            "bookingid": 24,
            "booking": {
            "firstname": "Ahmet",
            "lastname": "Bulut",
            "totalprice": 500,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2021-06-01",
                "checkout": "2021-06-10"
                },
            "additionalneeds": "wi-fi"
            }
        }

            Request body
        {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                },
            "additionalneeds" : "wi-fi"
        }
         */

        // 1- endpoint ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject rezTarihleriJson = new JSONObject();

        rezTarihleriJson.put("checkin", "2021-06-01");
        rezTarihleriJson.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", rezTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");

        System.out.println(requestBody.toString());


        // 2- expected data olustur

        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid", 24);
        expectedData.put("booking", requestBody);

        //System.out.println(expectedData.toString());


        // 3- request gonder ve donen response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);

        //response.prettyPrint();


        // 4- Assertion

        JsonPath responseJsonPath = response.jsonPath();
        // ilk yazilan expected ====> olusturdugumuz JSonObject : expectedData
        // ikinci yazilan actual ===> response : responseJsonPath

        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));

    }
}
