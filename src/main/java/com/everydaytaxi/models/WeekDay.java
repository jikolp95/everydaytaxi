package com.everydaytaxi.models;

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
}
