package com.gutstore.shoes;

import com.everydaytaxi.utils.HibernateUtil;
import com.gutstore.model.Shoes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

/**
 * Created by yeldos on 11/13/17.
 */
public class ShoesDaoImpl implements ShoesDao {
    private static final String GENDER = "gender";
    private static final String GENDER_NAME = "gender.name";
    private static final String SHOES_TYPE = "shoesType";
    private static final String SHOES_TYPE_NAME = "shoesType.name";
    private static final String BRAND = "brand";
    private static final String BRAND_NAME = "brand.name";
    private static final String SEASON = "season";
    private static final String SEASON_NAME = "season.name";
    private static final String PRICE = "price";
    private static final String SIZES = "sizes";
    private static final String SIZES_NAME = "sizes.size";
    private static final String COLOR = "color";
    private static final String COLOR_NAME = "color.name";
    private static final String UP_MATERIAL = "up";
    private static final String UP_MATERIAL_NAME = "up.name";
    private static final String STYLE = "style";
    private static final String STYLE_NAME = "style.name";
    private final SessionFactory sessionFactory;

    public ShoesDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Shoes> getAllShoes() {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria cr = session.createCriteria(Shoes.class);
        List<Shoes> shoesList = (List<Shoes>) cr.list();
        session.getTransaction().commit();
        session.close();
        for (Shoes aShoesList : shoesList) {
            System.out.println(aShoesList.toString());
        }
        return shoesList;
    }

    public List<Shoes> getShoesByOptions(Map<String, List<String>> options) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria cr = session.createCriteria(Shoes.class);
        for (Map.Entry<String, List<String>> option : options.entrySet()) {
            String key = option.getKey();
            if (key.equals(BRAND)) {
                cr.createAlias(BRAND, BRAND);
                cr.add(Restrictions.in(BRAND_NAME, option.getValue()));
            }
            if (key.equals(PRICE)) {
                cr.add(Restrictions.between(PRICE, option.getValue().get(0), option.getValue().get(1)));
            }
            if (key.equals(SHOES_TYPE)) {
                cr.createAlias(SHOES_TYPE, SHOES_TYPE);
                cr.add(Restrictions.in(SHOES_TYPE_NAME, option.getValue()));
            }
            if (key.equals(SIZES)) {
                cr.createAlias(SIZES, SIZES);
                cr.add(Restrictions.in(SIZES_NAME, option.getValue()));
            }
            if (key.equals(COLOR)) {
                cr.createAlias(COLOR, COLOR);
                cr.add(Restrictions.in(COLOR_NAME, option.getValue()));
            }
            if (key.equals(SEASON)) {
                cr.createAlias(SEASON, SEASON);
                cr.add(Restrictions.in(SEASON_NAME, option.getValue()));
            }
            if (key.equals(UP_MATERIAL)) {
                cr.createAlias(UP_MATERIAL, UP_MATERIAL);
                cr.add(Restrictions.in(UP_MATERIAL_NAME, option.getValue()));
            }
            if (key.equals(STYLE)) {
                cr.createAlias(STYLE, STYLE);
                cr.add(Restrictions.in(STYLE_NAME, option.getValue()));
            }
            if (key.equals(GENDER)) {
                cr.createAlias(GENDER, GENDER);
                cr.add(Restrictions.in(GENDER_NAME, option.getValue()));
            }

        }

        final List<Shoes> shoesList = (List<Shoes>) cr.list();
        session.getTransaction().commit();
        session.close();
        for (Shoes aShoesList : shoesList) {
            System.out.println(aShoesList.toString());
        }
        return shoesList;
    }
}
