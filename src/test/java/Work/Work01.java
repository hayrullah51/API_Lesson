package Work;

import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Work01 extends AutomationExercise {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo (H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void test01() {

        //Set the URL
        spec.pathParams("first","api","second","brandsList");

        //2. Set The Expected Data

        //3. Send The Request And Get The Response

        Response response = given().spec(spec).when().contentType(ContentType.JSON).get("/{first}/{second}");
        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
       List<String> poloList = jsonPath.getList("brands.findAll{it.brand=='Polo'}.brand");
        System.out.println("Polo list : " + poloList);
        int polo = poloList.size();

        List<String> hAndMList = jsonPath.getList("brands.findAll{it.brand=='H&M'}.brand");





        //Do Assertion
        assertEquals(200,response.statusCode());
        assertEquals("text/html; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());
        assertEquals(poloList.size(),hAndMList.size());




    }
}
