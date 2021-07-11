package bookerAPI_PojoClasses;

import common_utilities.BasePage;

public class BookingDatesPayload extends BasePage {
    private String checkin;
    private String checkout;

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
}
