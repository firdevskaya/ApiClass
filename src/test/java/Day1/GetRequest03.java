package Day1;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetRequest03 {
    /*
           https://restful-booker.herokuapp.com/booking/1001 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 404 oldugunu
    ve Response body'sinin "Not Found" icerdigini
    ve Response body'sinin "API" icermedigini test edin
         */

   @Test
    public  void test1(){
       String url="https://restful-booker.herokuapp.com/booking";
       Response response= given()
               .accept("application/json")
               .when()
               .get(url);
         response.prettyPrint();

         response.then().assertThat().statusCode(404);
         Assert.assertTrue(response.asString().contains("Not Found"));
         Assert.assertTrue(response.asString().contains("API"));



   }

}
