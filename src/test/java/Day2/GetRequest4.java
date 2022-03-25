package Day2;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class GetRequest4 {
    @Test
    public void test1(){

 /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Mary"
ve lastname'in "Jones"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */

String url="  https://restful-booker.herokuapp.com/booking/7";
        Response response=given()
                .accept("application/json")
                .when()
                .get(url);
        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", Matchers.equalTo("Mark"))
                .body("lastname",Matchers.equalTo("Ericsson"))
                .body("bookingdates.checkin",Matchers.equalTo("2017-06-29"))
                .body("bookingdates.checkout",Matchers.equalTo("2020-07-12"));




    }
}
