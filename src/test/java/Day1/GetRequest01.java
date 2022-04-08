package Day1;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    /*
    https://restful-booker.herokuapp.com/booking adresine bir request gonderildiginde
    donecek cevap(response) icin
HTTP status kodunun 200
Content Type’in Json
Ve Status Line’in


Oldugunu test edin

   */

@Test
    public void test(){


    String url ="https://restful-booker.herokuapp.com/booking ";
    Response response= given().accept(ContentType.JSON)
            .when()
            .get(url);

  //  response.prettyPrint();


    System.out.println("status code :"+  response.getStatusCode());
    System.out.println("contentype :"+ response.getContentType());
    System.out.println("statusline : "+  response.statusLine());




      response.then().assertThat()
              .statusCode(200)
              .contentType("application/json")
              .statusLine("HTTP/1.1 200 OK");

}


}


















