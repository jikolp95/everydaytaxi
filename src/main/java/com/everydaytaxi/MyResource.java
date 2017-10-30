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
    @Path("/addbooking/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBooking(@PathParam("userId") int userId, String booking) {
        Booking booking1 = new Genson().deserialize(booking, Booking.class);
        new HibernateTest().addBooking(userId, booking1);
        return "ok";
    }


    @POST
    @Path("/updatebooking")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBooking(String booking) {
        Booking booking1 = new Genson().deserialize(booking, Booking.class);
        new HibernateTest().updateBooking(booking1);
        return "ok";
    }
    @POST
    @Path("/deletebooking/{userId}/{bookingId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBooking(@PathParam("userId") int userId,@PathParam("bookingId") int bookingId) {
        new HibernateTest().deleteBooking(userId, bookingId);
        return "ok";
    }


}
