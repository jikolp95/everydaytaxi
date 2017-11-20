package com.gutstore.others;

import com.gutstore.model.productFeature.*;
import com.owlike.genson.Genson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by yeldos on 11/14/17.
 */
@Path("other")
public class OthersResource {
    private Genson genson = new Genson();
    private final OthersDaoImpl othersDao = new OthersDaoImpl();

    @GET
    @Path("/brands")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBrands() {
        List<Brand> brands = othersDao.getBrandList();
        return genson.serialize(brands);
    }

    @GET
    @Path("/seasons")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSeasons() {
        List<Season> seasons = othersDao.getSeasonList();
        return genson.serialize(seasons);
    }

    @GET
    @Path("/shoestypes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getShoesType() {
        List<ShoesType> shoestypes = othersDao.getShoesType();
        return genson.serialize(shoestypes);
    }

    @GET
    @Path("/accessoriestypes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccessoriesType() {
        List<AccessoriesType> accessoriestypes = othersDao.getAccessoriesType();
        return genson.serialize(accessoriestypes);
    }

    @GET
    @Path("/genders")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGenderList() {
        List<Gender> genders = othersDao.getGenderList();
        return genson.serialize(genders);
    }

    @GET
    @Path("/materials")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMaterials() {
        List<Material> materials = othersDao.getMaterials();
        return genson.serialize(materials);
    }

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountryList() {
        List<Country> countries = othersDao.getCountryList();
        return genson.serialize(countries);
    }

    @GET
    @Path("/styles")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStyleList() {
        List<Style> styles = othersDao.getStyleList();
        return genson.serialize(styles);
    }

    @GET
    @Path("/colors")
    @Produces(MediaType.APPLICATION_JSON)
    public String getColorList() {
        List<Color> colors = othersDao.getColorList();
        return genson.serialize(colors);
    }

    @GET
    @Path("/sizes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSizeList() {
        List<Size> sizes = othersDao.getSizeList();
        return genson.serialize(sizes);
    }
}
