package get_request;

import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get08Work extends AutomationExercise {
    /*
      Given
          https://automationexercise.com/api/productsList
      When
          User sends a GET Request to the url
      Then
          HTTP Status Code should be 200
      And
          Content Type should be "text/html; charset=utf-8"
      And
          Status Line should be HTTP/1.1 200 OK
      And
           There must be 12 Women, 9 Men, 13 Kids usertype in products
        */

    @Test
    public void test08 (){
        //1. Set The Url
        spec.pathParams("first","api","second","productsList");

        //2. Set The Expected Data

        //3. Send The Request And Get The Response
      Response response = given().spec(spec).when().get("/{first}/{second}");
     // response.prettyPrint();

        //4. Do Assertion
        response.then().statusCode(200).
                contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        /*
        List<String> womanList = jsonPath.getList("products.category.usertype.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> manList = jsonPath.getList("products.category.usertype.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> kidList = jsonPath.getList("products.category.usertype.usertype.findAll{it.usertype=='Kids'}.usertype");

        assertEquals(12,womanList.size());
        assertEquals(9,manList.size());
        assertEquals(13,kidList.size());

         */

        List<String> usertype = jsonPath.getList("products.category.usertype.usertype");

        assertEquals(12, usertype.stream().filter(t -> t.equals("Women")).count());
        assertEquals(9, usertype.stream().filter(t -> t.equals("Men")).count());
        assertEquals(13, usertype.stream().filter(t -> t.equals("Kids")).count());




    }
}
