package bookerAPI_stepDefinitions;

import bookerAPI.BookerAPI_Requests;
import bookerAPI_utilities.CreateBookingResponsePayload;
import common_utilities.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class CreateBooking extends BasePage {

    BookerAPI_Requests request=new BookerAPI_Requests();
    CreateBookingResponsePayload response=null;


    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String resource) throws IOException {
        response=request.createBookingRequest(resource);
    }

    @Then("user receives a successful response and a booking ID is generated")
    public void user_receives_a_successful_response_and_a_booking_id_is_generated() throws IOException {
        String bookingid=String.valueOf(response.getBookingid());
        System.out.println("booking ID is "+bookingid);
        setProperty("bookingid", bookingid);


    }

}
