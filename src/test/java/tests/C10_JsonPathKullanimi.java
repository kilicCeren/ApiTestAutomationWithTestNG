package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    /*
    {
        "firstName": "John",
        "lastName": "Doe",
        "age": 26,
        "address": {
            "streetAddress": "naist street",
            "city": "Nara",
            "postalCode": "630-0192"
         }
           "phoneNumbers": [
            {
                "type": "iPhone",
                "number": "0123-4567-8888"
            },
            {
                "type": "home",
                "number": "0123-4567-8910"
            }
          ]
       }
     */

    @Test
    public void mehod1() {

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adresJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();

        JSONObject cepTelJsonObj = new JSONObject();

        JSONObject evTelJsonObj = new JSONObject();


        adresJsonObj.put("streetAddress", "naist street");
        adresJsonObj.put("city", "Nara");
        adresJsonObj.put("postalCode", "630-0192");

        cepTelJsonObj.put("type", "iPhone");
        cepTelJsonObj.put("number", "0123-4567-8888");
        evTelJsonObj.put("type", "home");
        evTelJsonObj.put("number", "0123-4567-8910");

        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstName", "John");
        kisiBilgileriJsonObj.put("lastName", "Doe");
        kisiBilgileriJsonObj.put("age", 26);
        kisiBilgileriJsonObj.put("address", adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);

        System.out.println("firstName : " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("lastName : " + kisiBilgileriJsonObj.get("lastName"));

        System.out.println("cadde : " + kisiBilgileriJsonObj.getJSONObject("address")
                .get("streetAddress"));

        System.out.println("city : " + kisiBilgileriJsonObj.getJSONObject("address")
                .get("city"));

        System.out.println("cep tel number: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers")
                .getJSONObject(0).get("number"));

        //Yukarıda kullandığımız yöntem çok uzun hataya sebep olacagi icin  biz Json Path kullaniyoruz.
        //JsonPath Kullanirken ne kadar iceri dogru gitmek istiyorsaniz o kadar nokta koymaniz gerekmektedir.

        // $ yazdigimizda tum bilgileeri verir.
        //firstname yazarsak Jhon gelir
        //address.city dersek Nara'yı bize verir.
        //$.phoneNumbers[0].type = iphone
        //$.phoneNumbers[0].number = 0123-4567-8888

        //https://jsonpath.com/ bu adreste denemeler yapılabilir.

    }
}
