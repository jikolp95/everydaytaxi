package com.everydaytaxi;

import com.everydaytaxi.bookingDao.BookingDao;
import com.everydaytaxi.models.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class HibernateTest implements BookingDao {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("econom", "001kdd01", "Danial", "Kudaibergen", new Date(1994, 12, 8), "Shevchenko72");
        Taxi taxi1 = new Taxi("lux", "777kdd02", "Yeldos", "Yeleubayev", new Date(1995, 01, 22), "Lebedeva70");
        City astana = new City();
        astana.setCity_name("Astana");
        City almaty = new City();
        almaty.setCity_name("Almaty");

        WeekDay monday = new WeekDay("monday");
        WeekDay tuesday = new WeekDay("tuesday");
        WeekDay wednesday = new WeekDay("wednesday");
        WeekDay thuesday = new WeekDay("thuesday");
        WeekDay friday = new WeekDay("friday");
        WeekDay saturday = new WeekDay("saturday");
        WeekDay sunday = new WeekDay("sunday");


        Booking booking1 = new Booking("for adults", new Date(), new Date(), Arrays.asList(monday, wednesday, friday), 1, 2,
                0, new Date(),
                new Date(), "econom", taxi, almaty, "update booking"
        );
        Booking booking = new Booking("for child", new Date(), new Date(), Arrays.asList(tuesday, thuesday, saturday), 1, 2,
                0, new Date(),
                new Date(), "lux", taxi1, astana, "update booking"
        );
        Booking booking2 = new Booking("for youngandwild", new Date(), new Date(), Arrays.asList(monday, wednesday, friday), 1, 2,
                0, new Date(),
                new Date(), "lux", taxi, almaty, "added booking"
        );


//        monday.setBooking(booking1);
//        wednesday.setBooking(booking1);
//        friday.setBooking(booking1);
//        thuesday.setBooking(booking);
//        tuesday.setBooking(booking);
//        saturday.setBooking(booking);


        User user = new User("87782480303", "qwer12", "root", almaty, Arrays.asList(booking1));
        User user1 = new User("87019205111", "qwer12", "root", astana, Arrays.asList(booking));
//        booking1.setUser(user);
//        booking.setUser(user1);

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(user);
//        session.persist(user1);
//        session.getTransaction().commit();
//        session.close();


//        changeBooking(booking1);


//        ----------GET BOOKING LIST
//        List<Booking> bookingList = new com.everydaytaxi.HibernateTest().getBookingList(1);
//        System.out.println(bookingList.size());
//        for (Booking booking : bookingList) {
//            System.out.println(booking.toString());
//        }


//        ----------GET BOOKING
//        Booking booking2 = new com.everydaytaxi.HibernateTest().getBooking(1, 1);
//        if (booking2 != null) {
//            System.out.println(booking2.toString());
//        } else {
//            System.out.println("does not find this object");
//        }
//        ----------DELETE BOOKING
//        new com.everydaytaxi.HibernateTest().deleteBooking(1,1);

//        ----------ADD BOOKING
//        new HibernateTest().addBooking(1,booking2);

    }

    public void changeBooking(int userId, Booking booking) {

    }

    public Booking getBooking(int userId, int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            user.getBookings().add(booking);
            response = "ok";
        }
        session.getTransaction().commit();
        session.close();
        return response;
    }

    public void deleteBooking(int userId, int bookingId) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Booking booking = session.get(Booking.class, bookingId);
        session.delete(booking);
        session.getTransaction().commit();
        session.close();

    }
}
