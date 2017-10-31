package com.everydaytaxi;

import com.everydaytaxi.bookingDao.BookingDaoImpl;
import com.everydaytaxi.models.User;
import com.everydaytaxi.userDao.UserDao;
import com.everydaytaxi.userDao.UserDaoImpl;
import com.everydaytaxi.utils.HibernateUtil;
import com.owlike.genson.Genson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by yeldos on 10/31/17.
 */

@Path("user")
public class UserResource {
    private final Genson genson = new Genson();
    private final UserDaoImpl userDao = new UserDaoImpl();

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int userId) {

    }

    public void getUserList() {

    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("userId") int userId) {
        User user = userDao.getUser(userId);
        return genson.serialize(user);
    }
}
