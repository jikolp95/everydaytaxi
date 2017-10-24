package com.everydaytaxi;

import com.everydaytaxi.models.Booking;
import com.owlike.genson.Genson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        Booking booking2 = new com.everydaytaxi.HibernateTest().getBooking(1, 1);
        Genson genson=new Genson();
        return genson.serialize(booking2);
    }
}
