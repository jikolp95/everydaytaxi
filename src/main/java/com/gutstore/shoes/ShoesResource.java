package com.gutstore.shoes;

import com.gutstore.model.Shoes;
import com.owlike.genson.Genson;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by yeldos on 11/14/17.
 */
@Path("shoes")
public class ShoesResource {
    private final Genson genson = new Genson();
    private final ShoesDaoImpl shoesDao = new ShoesDaoImpl();
    private static final String OK_RESPONSE = "Ok";

    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getIt(String options) {
        Map<String, List<String>> optionsList = genson.deserialize(options, Map.class);
        final List<Shoes> shoesList = shoesDao.getShoesByOptions(optionsList);
        return genson.serialize(shoesList);
    }


}
