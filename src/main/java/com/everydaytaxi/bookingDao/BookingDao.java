package com.everydaytaxi.bookingDao;

import com.everydaytaxi.models.Booking;

import java.util.List;

/**
 * Created by yeldos on 10/23/17.
 */
public interface BookingDao {
    void updateBooking(Booking booking);

    Booking getBooking(int userId, int id);

    List<Booking> getBookingList(int userId);

    String addBooking(int userId, Booking booking);

    void deleteBooking(int userId, int bookingId);
}
