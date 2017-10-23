package bookingDao;

import models.Booking;
import models.User;

import java.util.List;

/**
 * Created by yeldos on 10/23/17.
 */
public interface BookingDao {
    void changeBooking(int userId, Booking booking);

    Booking getBooking(int userId, int id);

    List<Booking> getBookingList(int userId);

    void addBooking(int userId, Booking booking);

    void deleteBooking(int userId, int bookingId);
}
