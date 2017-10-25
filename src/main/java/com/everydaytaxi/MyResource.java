package com.everydaytaxi;

import com.everydaytaxi.models.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owlike.genson.Genson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Path("booking")
public class MyResource {
    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        List<Booking> booking2 = new com.everydaytaxi.HibernateTest().getBookingList(1);
        Genson genson = new Genson();
        String jsonInString = null;
        jsonInString = genson.serialize(booking2);
        return jsonInString;
    }

    @GET
    @Path("/2")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooking() {
        Booking booking = new HibernateTest().getBooking(1, 1);
        Genson genson = new Genson();
        String jsonInString = null;
        jsonInString = genson.serialize(booking);
        return jsonInString;
    }

    @POST
    @Path("/{userId}/addbooking")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addBooking(@PathParam("userId") int userId, @BeanParam Booking booking) {
        System.out.println(new Genson().serialize(booking));
//        new HibernateTest().addBooking(userId, booking);
        return "ok";
    }
}
