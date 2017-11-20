package com.gutstore.model.productFeature;

import javax.persistence.*;

/**
 * Created by yeldos on 11/14/17.
 */
@Entity
@Table(name = "dimensions")
public class Dimensions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dimensions;

    public Dimensions() {
    }

    public Dimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
