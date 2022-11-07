package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.*;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get15 extends RestfulBaseUrl {

    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
          {
    "firstname": "Guoqiang",
    "lastname": "Morante Briones",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void test15(){

        //Set the URL
        spec.pathParams("first","booking","second",22);

        //Set the Excepted Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo exceptedData = new BookingPojo("Guoqiang","Morante Briones",111,true,bookingDatesPojo,"Breakfast");

        //Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
      BookingPojo actualData =  ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);

      assertEquals(200,response.statusCode());
      assertEquals(exceptedData.getFirstname(),actualData.getFirstname());
      assertEquals(exceptedData.getLastname(),actualData.getLastname());
      assertEquals(exceptedData.getTotalprice(),actualData.getTotalprice());
      assertEquals(exceptedData.getDepositpaid(),actualData.getDepositpaid());
      assertEquals(exceptedData.getDepositpaid(),actualData.getDepositpaid());
      assertEquals(exceptedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
      assertEquals(exceptedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
      assertEquals(exceptedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        //Soft Assertion
        //1. Adim
        SoftAssert softAssert = new SoftAssert();

        //2. Adim
        softAssert.assertEquals(actualData.getFirstname(),exceptedData.getFirstname(),"Firstname FAil");
        softAssert.assertEquals(actualData.getLastname(),exceptedData.getLastname(),"Lastname  FAil");
        softAssert.assertEquals(actualData.getTotalprice(),exceptedData.getTotalprice(),"Totalprice  FAil");
        softAssert.assertEquals(actualData.getDepositpaid(),exceptedData.getDepositpaid(),"Depositpaid FAil");
        softAssert.assertEquals(actualData.getAdditionalneeds(),exceptedData.getAdditionalneeds(),"Additionaldneeds FAil");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),exceptedData.getBookingdates().getCheckin(),"Check in FAil");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),exceptedData.getBookingdates().getCheckout(),"Check out FAil");
        softAssert.assertEquals(actualData.getAdditionalneeds(),exceptedData.getAdditionalneeds(),"Additionaldneeds FAil");

        softAssert.assertAll();


    }



}
