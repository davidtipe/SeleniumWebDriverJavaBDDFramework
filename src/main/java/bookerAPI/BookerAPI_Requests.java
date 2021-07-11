package bookerAPI;

import bookerAPI_PojoClasses.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import common_utilities.BasePage;
import common_utilities.RestAPI_Resources;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookerAPI_Requests extends BasePage {


    public CreateBookingRequestPayload createBookingPayload () throws IOException {
        CreateBookingRequestPayload cb=new CreateBookingRequestPayload();
        BookingDatesPayload bookingDates=new BookingDatesPayload();
        bookingDates.setCheckin(getCurrentDate().toString());
        bookingDates.setCheckout(addOneMonthToCurrentDate());
        cb.setFirstname(getProperty("firstName"));
        cb.setLastname(getProperty("lastName"));
        cb.setTotalprice(250);
        cb.setDepositpaid(true);
        cb.setBookingdates(bookingDates);
        cb.setAdditionalneeds(getProperty("additionalNeeds"));
        return cb;
    }

    public CreateBookingResponsePayload createBookingRequest (String resource) throws IOException {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new Header("Accept", "application/json"));
        headerList.add(new Header("Content-Type", "application/json"));
        Headers headers = new Headers(headerList);
        RestAPI_Resources resourceAPI= RestAPI_Resources.valueOf(resource);
        RestAssured.baseURI = getProperty("baseuri");
        String response=given().log().all().headers(headers).body(createBookingPayload()).when().post(resourceAPI.getResource()).then().statusCode(200).log().all().extract().response().asString();
        ObjectMapper mapper = new ObjectMapper();
        CreateBookingResponsePayload cbr = mapper.readValue(response, CreateBookingResponsePayload.class);
        return cbr;
    }


}
