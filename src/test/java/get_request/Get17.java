package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {
    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
        User sends GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."
     */

    @Test
    public void get17(){
        spec.pathParams("first","employee","second",2);

        DummyRestApiDataPojo dummyRestApiDataPojo = new DummyRestApiDataPojo("Tiger Nixon",320800,61,"");
        DummyRestApiResponseBodyPojo expectedData = new DummyRestApiResponseBodyPojo("success","Successfully! Record has been fetched.",dummyRestApiDataPojo);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiResponseBodyPojo actualData = response.as(DummyRestApiResponseBodyPojo.class);

        //DummyRestApiResponseBodyPojo acualData2 = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());






    }
}
