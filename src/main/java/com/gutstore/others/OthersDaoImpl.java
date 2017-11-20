package com.gutstore.others;

import com.everydaytaxi.utils.HibernateUtil;
import com.gutstore.model.Accessories;
import com.gutstore.model.productFeature.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by yeldos on 11/14/17.
 */
public class OthersDaoImpl implements OthersDao {
    private final SessionFactory sessionFactory;

    public OthersDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Brand> getBrandList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Brand.class);
        List<Brand> brands = criteria.list();
        session.getTransaction().commit();
        session.close();
        return brands;
    }

    public List<Season> getSeasonList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Season.class);
        List<Season> seasons = criteria.list();
        session.getTransaction().commit();
        session.close();
        return seasons;
    }

    public List<ShoesType> getShoesType() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ShoesType.class);
        List<ShoesType> shoesTypes = criteria.list();
        session.getTransaction().commit();
        session.close();
        return shoesTypes;
    }

    public List<AccessoriesType> getAccessoriesType() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Accessories.class);
        List<AccessoriesType> accessories = criteria.list();
        session.getTransaction().commit();
        session.close();
        return accessories;
    }

    public List<Gender> getGenderList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Gender.class);
        List<Gender> genders = criteria.list();
        session.getTransaction().commit();
        session.close();
        return genders;
    }

    public List<Material> getMaterials() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Material.class);
        List<Material> materials = criteria.list();
        session.getTransaction().commit();
        session.close();
        return materials;
    }

    public List<Country> getCountryList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Country.class);
        List<Country> countries = criteria.list();
        session.getTransaction().commit();
        session.close();
        return countries;
    }

    public List<Style> getStyleList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Style.class);
        List<Style> styles = criteria.list();
        session.getTransaction().commit();
        session.close();
        return styles;
    }

    public List<Color> getColorList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Color.class);
        List<Color> colors = criteria.list();
        session.getTransaction().commit();
        session.close();
        return colors;
    }

    public List<Size> getSizeList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Size.class);
        List<Size> sizes = criteria.list();
        session.getTransaction().commit();
        session.close();
        return sizes;
    }
}
