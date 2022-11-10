package Work;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;
import test_data.ReqrestTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Work02 extends ReqresBaseUrl {
//2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
    "name": "morpheus",
    "job": "leader",
    "id": "342",
    "createdAt": "2022-11-08T10:39:00.113Z"
}
*/

    @Test
    public void test02() {

        //Set the URL
        spec.pathParam("first","users");

        //Set the Excepted Data
        ReqrestTestData reqrestTestData = new ReqrestTestData();
        Map<String,String> expectedData = reqrestTestData.expectedDataMethod("morpheus","leader");
        System.out.println(expectedData);

        //Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Asertion
      Map<String,String> actualData =  response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));

    }

    @Test
    public void test02Pojo(){

        //Set the URL
        spec.pathParam("first","users");

        //Set the Excepted Data --> BU ADIMDA JAVA ILE YAZDIGIMIZI
        //Pojo class olusturacagiz cons yapilacak
        ReqresPojo expectedData = new ReqresPojo("morpheus","leader");
        System.out.println("Expected Data : " + expectedData);

        //Send
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
        response.prettyPrint();


        //Do Assertion RESPONSE JSON ILE DONUYOR
      ReqresPojo actualData = response.as(ReqresPojo.class);//Gson ile oluyor !!!
        assertEquals(expectedData.getName(),actualData.getName());



      ReqresPojo actualData2 =  ObjectMapperUtils.convertJsonToJava(response.asString(),ReqresPojo.class); // Object Mapper ile
        assertEquals(expectedData.getName(),actualData2.getName());








    }
}
