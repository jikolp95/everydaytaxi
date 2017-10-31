package com.everydaytaxi.bookingDao;

import com.everydaytaxi.models.*;
import com.everydaytaxi.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeldos on 10/23/17.
 */
public class BookingDaoImpl implements BookingDao {
    private final SessionFactory sessionFactory;

    public BookingDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void updateBooking(Booking booking) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Booking bookingFromDB = session.get(Booking.class, booking.getId_booking());
        if (bookingFromDB != null) {
            if (booking.getTitle() != null) {
                bookingFromDB.setTitle(booking.getTitle());
            }
            if (booking.getDate_from() != null) {
                bookingFromDB.setDate_from(booking.getDate_from());
            }
            if (booking.getDate_until() != null) {
                bookingFromDB.setDate_until(booking.getDate_until());
            }
            if (booking.getSpecific_day() != null) {
                List<WeekDay> weekDayList = (ArrayList<WeekDay>) booking.getSpecific_day();
                List<WeekDay> weekDays = new ArrayList<WeekDay>();
                for (WeekDay weekDay : weekDayList) {
                    weekDays.add(session.find(WeekDay.class, weekDay.getId_day()));
                }
                bookingFromDB.setSpecific_day(weekDays);
            }
            if (booking.getPoint_a() != 0) {
                bookingFromDB.setPoint_a(booking.getPoint_a());
            }
            if (booking.getPoint_b() != 0) {
                bookingFromDB.setPoint_b(booking.getPoint_b());
            }
            if (booking.getFeed_time() != null) {
                bookingFromDB.setFeed_time(booking.getFeed_time());
            }
            if (booking.getReturn_time() != null) {
                bookingFromDB.setReturn_time(booking.getReturn_time());
            }
            if (booking.getTaxi_class() != null) {
                bookingFromDB.setTaxi_class(booking.getTaxi_class());
            }
            if (booking.getTaxi() != null) {
                Taxi taxi = session.find(Taxi.class, booking.getTaxi().getId_taxi());
                bookingFromDB.setTaxi(taxi);
            }
            if (booking.getCity() != null) {
                City city = session.find(City.class, booking.getCity().getId_city());
                bookingFromDB.setCity(city);
            }
            if (booking.getComment() != null) {
                bookingFromDB.setComment(booking.getComment());
            }

            bookingFromDB.setRound_trip(booking.getRound_trip());
            session.update(bookingFromDB);
            session.getTransaction().commit();
            session.close();
        }
    }

    public Booking getBooking(int userId, int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            List<Booking> bookingList = (List<Booking>) user.getBookings();
            if (!bookingList.isEmpty()) {
                for (Booking booking :
                        bookingList) {
                    if (booking.getId_booking() == id) {
                        return booking;
                    }
                }
            }

        }
        return null;
    }

    public List<Booking> getBookingList(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        List<Booking> bookingList = (List<Booking>) user.getBookings();
        session.getTransaction().commit();
        session.close();
        return bookingList;
    }

    public String addBooking(int userId, Booking booking) {
        String response = "failure";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            City city = session.find(City.class, booking.getCity().getId_city());
            booking.setCity(city);
            Taxi taxi = session.find(Taxi.class, booking.getTaxi().getId_taxi());
            booking.setTaxi(taxi);
            List<WeekDay> weekDayList = (ArrayList<WeekDay>) booking.getSpecific_day();
            List<WeekDay> weekDays = new ArrayList<WeekDay>();
            for (WeekDay weekDay : weekDayList) {
                weekDays.add(session.find(WeekDay.class, weekDay.getId_day()));
            }
            booking.setSpecific_day(weekDays);
            user.getBookings().add(booking);
            session.update(user);
            response = "ok";
        }
        session.getTransaction().commit();
        session.close();
        return response;
    }

    public void deleteBooking(int userId, int bookingId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        Booking booking = session.get(Booking.class, bookingId);
        if (user != null) {
            user.getBookings().remove(booking);
            session.update(user);
        }
        session.getTransaction().commit();
        session.close();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(booking);
        session.getTransaction().commit();
        session.close();
    }
}
