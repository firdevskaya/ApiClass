package Day1;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    /*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde
    donecek cevap(response) icin
HTTP status kodunun 200
Content Type’in Json
Ve Status Line’in HTTP/1.1 200 OK
Oldugunu test edin

   */



    @Test
    public void get1(){
        // 1- api testi yaparken ilk olarak url(endpoint) belirlenmeli

        String url="https://restful-booker.herokuapp.com/booking";

        Response response=given().accept(ContentType.JSON)
                .when()
                .get(url);


        //  response.prettyPrint();
        //4-actual result oluştur
        //5-doğrulama yap(assertion)

        System.out.println("status code :"+ response.getStatusCode() );
        System.out.println("contentype "+ response.contentType());
        System.out.println("statusline "+ response.statusLine());

        response.then()
                .contentType("application/json")
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");




    }
}






