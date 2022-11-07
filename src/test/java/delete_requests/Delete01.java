package delete_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {

        //Set the URL
        spec.pathParams("first","todos","second",198);

        //Set the Excepted Data
        Map<String,String> expectedData = new HashMap<>();

        //Send the Request and Get the Response
       Response response = given().spec(spec).when().delete("/{first}/{second}");
       response.prettyPrint();

        //Do Assertion
       Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("Actual Data " + actualData);

        // 1. Yol
        assertEquals(200,response.statusCode());

        // 2. Yol
        assertTrue(actualData.isEmpty());

        // 3. Yol
        assertEquals(0,actualData.size());



    }
}
