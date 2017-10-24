package com.everydaytaxi;

import com.everydaytaxi.models.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owlike.genson.Genson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("myresource")
public class MyResource {
    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        List<Booking> booking2 = new com.everydaytaxi.HibernateTest().getBookingList(1);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(booking2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }

    @GET
    @Path("/2")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooking() {
        Booking booking = new HibernateTest().getBooking(1, 1);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }

}
