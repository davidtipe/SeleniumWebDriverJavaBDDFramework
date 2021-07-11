package bookerAPI_PojoClasses;

import common_utilities.BasePage;

public class CreateBookingResponsePayload extends BasePage {
    private int bookingid;
    private BookingPayload booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPayload getBooking() {
        return booking;
    }

    public void setBooking(BookingPayload booking) {
        this.booking = booking;
    }
}
