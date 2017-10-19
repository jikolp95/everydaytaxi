import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by yeldos on 10/19/17.
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date date_from;
    @Temporal(TemporalType.DATE)
    private Date date_until;
    @OneToMany (mappedBy = "orders", cascade =CascadeType.PERSIST)
    private Collection<WeekDay> specific_day = new ArrayList<WeekDay>();
    private long point_a;
    private long point_b;
    private int round_trip;
    @Temporal(TemporalType.TIME)
    private Date feed_time;
    @Temporal(TemporalType.TIME)
    private Date return_time;
    private String taxi_class;
    @OneToOne
    @JoinColumn(name = "id_taxi")
    private Taxi taxi;
    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;
    private String comment;
//    @ManyToOne
//    @JoinColumn(name = "id_user")
//    private User user;

    public Orders() {
    }

    public Orders(String title, Date date_from, Date date_until, Collection<WeekDay> specific_day, long point_a, long point_b, int round_trip, Date feed_time, Date return_time, String taxi_class, Taxi taxi, City city, String comment) {
        this.title = title;
        this.date_from = date_from;
        this.date_until = date_until;
        this.specific_day = specific_day;
        this.point_a = point_a;
        this.point_b = point_b;
        this.round_trip = round_trip;
        this.feed_time = feed_time;
        this.return_time = return_time;
        this.taxi_class = taxi_class;
        this.taxi = taxi;
        this.city = city;
        this.comment = comment;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_until() {
        return date_until;
    }

    public void setDate_until(Date date_until) {
        this.date_until = date_until;
    }

    public Collection<WeekDay> getSpecific_day() {
        return specific_day;
    }

    public void setSpecific_day(Collection<WeekDay> specific_day) {
        this.specific_day = specific_day;
    }

    public long getPoint_a() {
        return point_a;
    }

    public void setPoint_a(long point_a) {
        this.point_a = point_a;
    }

    public long getPoint_b() {
        return point_b;
    }

    public void setPoint_b(long point_b) {
        this.point_b = point_b;
    }

    public int getRound_trip() {
        return round_trip;
    }

    public void setRound_trip(int round_trip) {
        this.round_trip = round_trip;
    }

    public Date getFeed_time() {
        return feed_time;
    }

    public void setFeed_time(Date feed_time) {
        this.feed_time = feed_time;
    }

    public Date getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Date return_time) {
        this.return_time = return_time;
    }

    public String getTaxi_class() {
        return taxi_class;
    }

    public void setTaxi_class(String taxi_class) {
        this.taxi_class = taxi_class;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Orders{" +
                "id_order=" + id_order +
                ", title='" + title + '\'' +
                ", date_from=" + date_from +
                ", date_until=" + date_until +
                ", specific_day=" + specific_day +
                ", point_a=" + point_a +
                ", point_b=" + point_b +
                ", round_trip=" + round_trip +
                ", feed_time=" + feed_time +
                ", return_time=" + return_time +
                ", taxi_class='" + taxi_class + '\'' +
                ", taxi=" + taxi +
                ", city=" + city +
                ", comment='" + comment + '\'' +
                '}';
    }
}
