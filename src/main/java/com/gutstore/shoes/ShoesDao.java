package com.gutstore.shoes;

import com.gutstore.model.Shoes;

import java.util.List;
import java.util.Map;

/**
 * Created by yeldos on 11/13/17.
 */
public interface ShoesDao {
    List<Shoes> getAllShoes();

    List<Shoes> getShoesByOptions(Map<String, List<String>> options);

}
