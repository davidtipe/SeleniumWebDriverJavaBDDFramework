package common_utilities;

public enum RestAPI_Resources {

    createBookingAPI ("/booking"),
    updateBookingAPI("/booking/:id"),
    deleteBookingAPI("/booking/1");

    private String resource;

    RestAPI_Resources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
