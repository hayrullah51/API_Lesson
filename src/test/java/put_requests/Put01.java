package put_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Put01 extends JsonplaceholderBaseUrl {

    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
 */

    @Test
    public void test01(){

        //Set the url
        spec.pathParams("1","todos","2",198);

        //Set the expected Data

        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
       Map<String,Object> expectedDataMap = obj.expectedDataMethod(21,"Wash the dishes",false);
        System.out.println("ecpected Data : " + expectedDataMap);

        //Send the Request and Get the responce
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().put("/{1}/{2}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actual Data : " + actualData);

        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));
        assertEquals(expectedDataMap.get("title"),actualData.get("title"));
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));



    }
}
