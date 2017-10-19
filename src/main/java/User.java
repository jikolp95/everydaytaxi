import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yeldos on 10/19/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String phone_number;
    private String password;
    private String username;
    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Orders> orders = new ArrayList<Orders>();

    public User() {
    }

    public User(String phone_number, String password, String username, City city, Collection<Orders> orders) {
        this.phone_number = phone_number;
        this.password = password;
        this.username = username;
        this.city = city;
        this.orders = orders;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }



    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", city=" + city +
                ", orders=" + orders +
                '}';
    }
}
