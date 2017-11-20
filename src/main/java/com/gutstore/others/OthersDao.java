package com.gutstore.others;

import com.gutstore.model.productFeature.*;

import java.util.List;

/**
 * Created by yeldos on 11/14/17.
 */
public interface OthersDao {
    List<Brand> getBrandList();

    List<Season> getSeasonList();

    List<ShoesType> getShoesType();

    List<AccessoriesType> getAccessoriesType();

    List<Gender> getGenderList();

    List<Material> getMaterials();

    List<Country> getCountryList();

    List<Style> getStyleList();

    List<Color> getColorList();

    List<Size> getSizeList();
}
