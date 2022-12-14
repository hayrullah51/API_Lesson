package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get02b extends ReqresBaseUrl {

    /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty

*/
    @Test
    public void get02(){
        spec.pathParams("first","api","second","users","third",23);


        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        System.out.println(response.statusCode());
        assertEquals(404,response.getStatusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(2, response.asString().replaceAll("\\s","").length());



    }

}
