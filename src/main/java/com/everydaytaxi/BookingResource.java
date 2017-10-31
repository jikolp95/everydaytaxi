package com.everydaytaxi;

import com.everydaytaxi.bookingDao.BookingDaoImpl;
import com.everydaytaxi.models.Booking;
import com.everydaytaxi.utils.HibernateUtil;
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
public class BookingResource {
    private final Genson genson = new Genson();
    private final BookingDaoImpl bookingDao = new BookingDaoImpl();
    private static final String OK_RESPONSE = "Ok";

    @GET
    @Path("/list/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt(@PathParam("userId") int userId) {
        final List<Booking> bookingList = bookingDao.getBookingList(userId);
        return genson.serialize(bookingList);
    }

    @GET
    @Path("/{userId}/{bookingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooking(@PathParam("userId") int userId, @PathParam("bookingId") int bookingId) {
        final Booking booking = bookingDao.getBooking(userId, bookingId);
        return genson.serialize(booking);
    }

    @POST
    @Path("/add/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBooking(@PathParam("userId") int userId, String bookingJson) {
        Booking booking = genson.deserialize(bookingJson, Booking.class);
        bookingDao.addBooking(userId, booking);
        return OK_RESPONSE;
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBooking(String bookingJson) {
        Booking booking = genson.deserialize(bookingJson, Booking.class);
        bookingDao.updateBooking(booking);
        return OK_RESPONSE;
    }

    @POST
    @Path("/delete/{userId}/{bookingId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBooking(@PathParam("userId") int userId, @PathParam("bookingId") int bookingId) {
        bookingDao.deleteBooking(userId, bookingId);
        return OK_RESPONSE;
    }


}
