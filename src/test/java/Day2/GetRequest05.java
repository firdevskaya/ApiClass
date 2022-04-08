package Day2;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {


     /*
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    ve content type'inin "application/json"
    ve firstname'in “Jim"
    ve totalprice’in 600
    ve checkin date'in 2015-06-12"oldugunu test edin





    {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 396,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2017-07-24",
        "checkout": "2017-09-20"
    }
}
    */


    @Test


    public void  test1(){
        String url="https://restful-booker.herokuapp.com/booking/5 ";
        Response response= given()
                .accept("application/json")
                .when()
                .get(url);
        response.prettyPrint();



    response.then()
            .statusCode(200)
            .contentType("application/json")
            .body("firstname", Matchers.equalTo("Jim"))
            .body("totalprice",Matchers.equalTo(740))
            .body("bookingdates.checkin",Matchers.equalTo("2017-07-24"));





    }
}
