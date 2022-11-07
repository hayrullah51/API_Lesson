package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get13Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "female"
                 }
          }
    */

    @Test
    public void get13Pojo(){
        //Set the URL
        spec.pathParams("first","users","second",2508);

        //Set the Expected Data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,"Sharmila Deshpande VM","deshpande_sharmila_vm@becker.name","female","active");
        GoRestPojo expectedData = new GoRestPojo(null,goRestDataPojo);
        System.out.println("Excepted Data : " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
       GoRestPojo actualData = response.as(GoRestPojo.class);

       assertEquals(goRestDataPojo.getId(),actualData.getData().getId());
       assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
       assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
       assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
       assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());
       assertEquals(expectedData.getMeta(),actualData.getMeta());
    }
}
