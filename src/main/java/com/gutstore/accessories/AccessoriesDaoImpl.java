package com.gutstore.accessories;

import com.everydaytaxi.utils.HibernateUtil;
import com.gutstore.model.Accessories;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

/**
 * Created by yeldos on 11/14/17.
 */
public class AccessoriesDaoImpl implements AccessoriesDao {
    private static final String GENDER = "gender";
    private static final String GENDER_NAME = "gender.name";
    private static final String ACCESSORIES_TYPE = "accessoriesType";
    private static final String ACCESSORIES_TYPE_NAME = "accessoriesType.name";
    private static final String BRAND = "brand";
    private static final String BRAND_NAME = "brand.name";
    private static final String SEASON = "season";
    private static final String SEASON_NAME = "season.name";
    private static final String PRICE = "price";
    private static final String COLOR = "color";
    private static final String COLOR_NAME = "color.name";
    private static final String UP_MATERIAL = "up";
    private static final String UP_MATERIAL_NAME = "up.name";
    private static final String STYLE = "style";
    private static final String STYLE_NAME = "style.name";

    private final SessionFactory sessionFactory;

    public AccessoriesDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Accessories> getAllAccessories() {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria cr = session.createCriteria(Accessories.class);
        List<Accessories> accessoriesList = (List<Accessories>) cr.list();
        session.getTransaction().commit();
        session.close();
        for (Accessories accessories : accessoriesList) {
            System.out.println(accessories.toString());
        }
        return accessoriesList;
    }

    public List<Accessories> getAccessoriesByOptions(Map<String, List<String>> options) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria cr = session.createCriteria(Accessories.class);
        for (Map.Entry<String, List<String>> option : options.entrySet()) {
            String key = option.getKey();
            if (key.equals(BRAND)) {
                cr.createAlias(BRAND, BRAND);
                cr.add(Restrictions.in(BRAND_NAME, option.getValue()));
            }
            if (key.equals(PRICE)) {
                cr.add(Restrictions.between(PRICE, option.getValue().get(0), option.getValue().get(1)));
            }
            if (key.equals(ACCESSORIES_TYPE)) {
                cr.createAlias(ACCESSORIES_TYPE, ACCESSORIES_TYPE);
                cr.add(Restrictions.in(ACCESSORIES_TYPE_NAME, option.getValue()));
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

        final List<Accessories> accessoriesList = (List<Accessories>) cr.list();
        session.getTransaction().commit();
        session.close();
        for (Accessories accessories : accessoriesList) {
            System.out.println(accessories.toString());
        }
        return accessoriesList;
    }
}
