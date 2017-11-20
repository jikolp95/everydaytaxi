package com.gutstore.model.productFeature;

import javax.persistence.*;

/**
 * Created by yeldos on 11/13/17.
 */
@Entity
@Table(name = "shoesType")
public class ShoesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public ShoesType() {
    }

    public ShoesType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShoesType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
