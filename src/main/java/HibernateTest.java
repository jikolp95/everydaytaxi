import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;


public class HibernateTest {
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


        Orders orders1 = new Orders("for child", new Date(), new Date(), Arrays.asList(monday, wednesday, friday), 1, 2,
                0, new Date(),
                new Date(), "econom", taxi, almaty, "first order"
        );

        monday.setOrders(orders1);
        wednesday.setOrders(orders1);
        friday.setOrders(orders1);


        User user = new User("87782480303", "qwer12", "root", almaty, Arrays.asList(orders1));
//        orders1.setUser(user);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.save(taxi);
        session.save(almaty);
        session.getTransaction().commit();
        session.close();


    }
}
