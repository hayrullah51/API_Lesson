package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post04Pojo extends RestfulBaseUrl {
    /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        },
                                        "additionalneeds": "Breakfast"
                                     }
                                  }
     */

    @Test
    public void post04Pojo() {
        //Set the URL
        spec.pathParam("first", "booking");

        //Setthe Excepted Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo exceptedData = new BookingPojo("Ali", "Can", 999, true, bookingDatesPojo, "Breakfast");

        //Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(exceptedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        BookingResponseBodyPojo actualData = response.as(BookingResponseBodyPojo.class);
        System.out.println("Actual Data : " + actualData);

        assertEquals(exceptedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(exceptedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(exceptedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(exceptedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(exceptedData.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(exceptedData.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(exceptedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());


    }
}
