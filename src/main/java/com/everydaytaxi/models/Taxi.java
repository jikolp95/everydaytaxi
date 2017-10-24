package com.everydaytaxi.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yeldos on 10/19/17.
 */
@Entity
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_taxi;
    private String taxi_class;
    private String car_number;
    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String living_address;

    public Taxi() {
    }

    public Taxi(String taxi_class, String car_number, String name, String surname, Date birthday, String living_address) {
        this.taxi_class = taxi_class;
        this.car_number = car_number;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.living_address = living_address;
    }

    public int getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

    public String getTaxi_class() {
        return taxi_class;
    }

    public void setTaxi_class(String taxi_class) {
        this.taxi_class = taxi_class;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLiving_address() {
        return living_address;
    }

    public void setLiving_address(String living_address) {
        this.living_address = living_address;
    }

    @Override
    public String toString() {
        return "com.everydaytaxi.models.Taxi{" +
                "id_taxi=" + id_taxi +
                ", taxi_class='" + taxi_class + '\'' +
                ", car_number='" + car_number + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", living_address='" + living_address + '\'' +
                '}';
    }


}
