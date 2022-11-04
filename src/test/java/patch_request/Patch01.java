package patch_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Patch01 extends JsonplaceholderBaseUrl {

    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "title": "Wash the dishes"
           }
    When
I send PATCH Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 10,
                   "title": "Wash the dishes",
                   "completed": true,
                   "id": 198
                   }
 */

    @Test
    public void patch01(){

        //Set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
      Map<String,Object> expectedData = obj.expectedDataMethod(null,"xxx",null );
        System.out.println("expeced data : " + expectedData);

        //Send the Request and Get the Response
       Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
       Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actual data title : " + actualData.get("title"));
       assertEquals(expectedData.get("title"),actualData.get("title"));
        System.out.println("actual data : "+actualData);
    }
}
