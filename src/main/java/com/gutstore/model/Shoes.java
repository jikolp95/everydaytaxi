package com.gutstore.model;

import com.gutstore.model.productFeature.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeldos on 11/13/17.
 */
@Entity
@Table(name = "shoes")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private List<Size> sizes = new ArrayList<Size>();
    private String price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
    @ManyToOne(cascade = CascadeType.ALL)
    private Season season;
    @ManyToOne(cascade = CascadeType.ALL)
    private ShoesType shoesType;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gender gender;
    @ManyToOne(cascade = CascadeType.ALL)
    private Material up;
    @ManyToOne(cascade = CascadeType.ALL)
    private Material lining;
    @ManyToOne(cascade = CascadeType.ALL)
    private Material sole;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;
    @ManyToOne(cascade = CascadeType.ALL)
    private Style style;
    @ManyToOne(cascade = CascadeType.ALL)
    private Color color;

    public Shoes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ShoesType getShoesType() {
        return shoesType;
    }

    public void setShoesType(ShoesType shoesType) {
        this.shoesType = shoesType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Material getUp() {
        return up;
    }

    public void setUp(Material up) {
        this.up = up;
    }

    public Material getLining() {
        return lining;
    }

    public void setLining(Material lining) {
        this.lining = lining;
    }

    public Material getSole() {
        return sole;
    }

    public void setSole(Material sole) {
        this.sole = sole;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", sizes=" + sizes +
                ", price='" + price + '\'' +
                ", brand=" + brand +
                ", season=" + season +
                ", shoesType=" + shoesType +
                ", gender=" + gender +
                ", up=" + up +
                ", lining=" + lining +
                ", sole=" + sole +
                ", country=" + country +
                ", style=" + style +
                ", color=" + color +
                '}';
    }
}
