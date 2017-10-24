package com.everydaytaxi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yeldos on 10/19/17.
 */
@Entity
public class City {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_city;
    private String city_name;
    private long lat;
    private long lon;

    public City() {
    }

    public City(String city_name, long lat, long lon) {
        this.city_name = city_name;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

}
