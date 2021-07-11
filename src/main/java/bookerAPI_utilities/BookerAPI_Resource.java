package bookerAPI_utilities;

public enum BookerAPI_Resource {

    createBookingAPI ("/booking"),
    updateBookingAPI("/booking/:id"),
    deleteBookingAPI("/booking/1");

    private String resource;

    BookerAPI_Resource(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
