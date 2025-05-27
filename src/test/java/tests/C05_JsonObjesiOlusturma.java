package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjesiOlusturma {

    @Test
    public void test01() {
        //Asagidaki JSON Objesini olusturup konsolda yazdirin.
        /*
           {
                "firstname":"Jim",
                "additionalneeds":"Breakfast",
                "bookingdates":{
                        "checkin":"2018-01-01",
                        "checkout":"2019-01-01"
                    },
                "totalprice":111,
                "depositpaid":true,
                "lastname":"Brown"
                }
         */

        // Once inner Json objesini olusturalım

        JSONObject dateJsonObject = new JSONObject();
        dateJsonObject.put("checkin", "2018-01-01");
        dateJsonObject.put("checkout", "2019-01-01");

        // Sonra outer Json objesini olusturup,yeri geldiginde inner objeyi koyalim

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "Jim");
        requestBody.put("additionalneeds", "Breakfast");
        requestBody.put("bookingdates", dateJsonObject);
        requestBody.put("totalprice", 111);
        requestBody.put("depositpaid", true);
        requestBody.put("lastname", "Brown");

        System.out.println(requestBody);

        /* Map'te de JsonObject'tede sıralama için garanti vermiyoruz.
           Ekledigimiz tüm keyler ve value'lar geldi.
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
             "checkin":"2018-01-01",
            "checkout":"2019-01-01"},
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
        }

         */

    }
}
