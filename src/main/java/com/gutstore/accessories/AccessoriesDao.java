package com.gutstore.accessories;

import com.gutstore.model.Accessories;

import java.util.List;
import java.util.Map;

/**
 * Created by yeldos on 11/14/17.
 */
public interface AccessoriesDao {
    List<Accessories> getAllAccessories();

    List<Accessories> getAccessoriesByOptions(Map<String, List<String>> options);
}
