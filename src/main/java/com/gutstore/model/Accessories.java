package com.gutstore.model;

import com.gutstore.model.productFeature.*;

import javax.persistence.*;

/**
 * Created by yeldos on 11/14/17.
 */
@Entity
@Table(name = "accessories")
public class Accessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String name;
    private String price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
    @ManyToOne(cascade = CascadeType.ALL)
    private Season season;
    @ManyToOne(cascade = CascadeType.ALL)
    private AccessoriesType accessoriesType;
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
    @ManyToOne
    private Dimensions dimensions;

    public Accessories() {
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

    public AccessoriesType getAccessoriesType() {
        return accessoriesType;
    }

    public void setAccessoriesType(AccessoriesType accessoriesType) {
        this.accessoriesType = accessoriesType;
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

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", brand=" + brand +
                ", season=" + season +
                ", accessoriesType=" + accessoriesType +
                ", gender=" + gender +
                ", up=" + up +
                ", lining=" + lining +
                ", sole=" + sole +
                ", country=" + country +
                ", style=" + style +
                ", color=" + color +
                ", dimensions=" + dimensions +
                '}';
    }
}
