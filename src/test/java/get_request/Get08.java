package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get08 extends JsonplaceholderBaseUrl {

    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/

    @Test
    public void test08() {
        spec.pathParams("first", "todos", "second", 2);
        Map<String, Object> expextedData = new HashMap<>();
        expextedData.put("userId", 1);
        expextedData.put("id", 2);
        expextedData.put("id", 2);
        expextedData.put("title", "quis ut nam facilis et officia qui");
        expextedData.put("completed", false);
        System.out.println(expextedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData : " + actualData);

        assertEquals(expextedData.get("userId"),actualData.get("userId"));
        assertEquals(expextedData.get("id"),actualData.get("id"));
        assertEquals(expextedData.get("title"),actualData.get("title"));
        assertEquals(expextedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());

    }

}
