package com.gutstore.model.productFeature;

import javax.persistence.*;

/**
 * Created by yeldos on 11/14/17.
 */
@Entity
@Table(name = "accessoriesType")
public class AccessoriesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public AccessoriesType() {
    }

    public AccessoriesType(String name) {
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
}
