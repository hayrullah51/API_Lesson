package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get12Pojo extends RestfulBaseUrl {
    /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
                        {
    "firstname": "Dane",
    "lastname": "Combs",
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
    public void get12Pojo(){

        //Set the url
        spec.pathParams("first","booking","second",18);

        //Set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo bookingPojo = new BookingPojo("Dane","Combs",111,true,bookingDatesPojo,"Breakfast");
        System.out.println(bookingPojo.toString());

        //Send the Request and Get the Responce
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

       BookingPojo actualData = response.as(BookingPojo.class);

        //Do assertion
        assertEquals(bookingPojo.getFirstname(),actualData.getFirstname());
        assertEquals(bookingPojo.getLastname(),actualData.getLastname());
        assertEquals(bookingPojo.getTotalprice(),actualData.getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(bookingPojo.getAdditionalneeds(),actualData.getAdditionalneeds());

    }
}
