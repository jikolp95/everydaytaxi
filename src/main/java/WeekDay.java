import javax.persistence.*;

/**
 * Created by yeldos on 10/19/17.
 */
@Entity
public class WeekDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_day;
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders orders;

    public WeekDay() {
    }

    public WeekDay(String name) {
        this.name = name;
    }

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "id_day=" + id_day +
                ", name='" + name + '\'' +
                '}';
    }
}
