package com.gutstore;

import com.everydaytaxi.utils.HibernateUtil;
import com.gutstore.model.Shoes;
import com.gutstore.model.productFeature.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;

/**
 * Created by yeldos on 11/13/17.
 */
public class Start {
    public static void main(String[] args) {
        Brand clarks = new Brand("Clarks");
        Brand adidas = new Brand("Adidas");
        Brand nike = new Brand("Nike");
        Color white = new Color("белый");
        Color black = new Color("черный");
        Country russia = new Country("Russia");
        Country usa = new Country("USA");
        Gender male = new Gender("мужской");
        Gender female = new Gender("женский");
        Material leather = new Material("кожа");
        Material rubber = new Material("резина");
        ShoesType botinki = new ShoesType("ботинки");
        ShoesType tufli = new ShoesType("туфли");
        Season aw2017 = new Season("Осень-Зима 2017");
        Size size40 = new Size("40");
        Size size41 = new Size("41");
        Size size42 = new Size("42");
        Size size43 = new Size("43");
        Size size44 = new Size("44");
        Style casual = new Style("casual");
        Style fashion = new Style("fashion");


        Shoes shoes = new Shoes();
        shoes.setBrand(clarks);
        shoes.setColor(white);
        shoes.setCountry(usa);
        shoes.setGender(female);
        shoes.setLining(leather);
        shoes.setUp(leather);
        shoes.setStyle(fashion);
        shoes.setSeason(aw2017);
        shoes.setSole(rubber);
        shoes.setName("Ботинки");
        shoes.setModel("OS121212");
        shoes.setPrice("54000");
        shoes.setShoesType(botinki);
        shoes.setSizes(Arrays.asList(size40, size41, size42));

        Shoes shoes1 = new Shoes();
        shoes1.setBrand(adidas);
        shoes1.setColor(white);
        shoes1.setCountry(usa);
        shoes1.setGender(female);
        shoes1.setLining(leather);
        shoes1.setUp(leather);
        shoes1.setStyle(fashion);
        shoes1.setSeason(aw2017);
        shoes1.setSole(rubber);
        shoes1.setName("Ботинки");
        shoes1.setModel("OS303030");
        shoes1.setPrice("55000");
        shoes1.setShoesType(botinki);
        shoes1.setSizes(Arrays.asList(size40, size41, size42));

        Shoes shoes2 = new Shoes();
        shoes2.setBrand(nike);
        shoes2.setColor(black);
        shoes2.setCountry(russia);
        shoes2.setGender(male);
        shoes2.setLining(leather);
        shoes2.setUp(leather);
        shoes2.setStyle(casual);
        shoes2.setSeason(aw2017);
        shoes2.setSole(rubber);
        shoes2.setName("Туфли");
        shoes2.setModel("OS202020");
        shoes2.setPrice("56000");
        shoes2.setShoesType(tufli);
        shoes2.setSizes(Arrays.asList(size43, size41, size42));

        Shoes shoes3 = new Shoes();
        shoes3.setBrand(nike);
        shoes3.setColor(black);
        shoes3.setCountry(russia);
        shoes3.setGender(male);
        shoes3.setLining(leather);
        shoes3.setUp(leather);
        shoes3.setStyle(casual);
        shoes3.setSeason(aw2017);
        shoes3.setSole(rubber);
        shoes3.setName("Туфли");
        shoes3.setModel("OS202020");
        shoes3.setPrice("56000");
        shoes3.setShoesType(tufli);
        shoes3.setSizes(Arrays.asList(size43, size41, size42));

        Shoes shoes4 = new Shoes();
        shoes4.setBrand(clarks);
        shoes4.setColor(white);
        shoes4.setCountry(russia);
        shoes4.setGender(female);
        shoes4.setLining(rubber);
        shoes4.setUp(rubber);
        shoes4.setStyle(fashion);
        shoes4.setSeason(aw2017);
        shoes4.setSole(rubber);
        shoes4.setName("Туфли");
        shoes4.setModel("OS202020");
        shoes4.setPrice("40000");
        shoes4.setShoesType(tufli);
        shoes4.setSizes(Arrays.asList(size44, size43, size41, size42));

        Shoes shoes5 = new Shoes();
        shoes5.setBrand(adidas);
        shoes5.setColor(black);
        shoes5.setCountry(usa);
        shoes5.setGender(male);
        shoes5.setLining(leather);
        shoes5.setUp(leather);
        shoes5.setStyle(casual);
        shoes5.setSeason(aw2017);
        shoes5.setSole(rubber);
        shoes5.setName("Туфли");
        shoes5.setModel("OS202020");
        shoes5.setPrice("84000");
        shoes5.setShoesType(botinki);
        shoes5.setSizes(Arrays.asList(size42));

        Shoes shoes6 = new Shoes();
        shoes6.setBrand(nike);
        shoes6.setColor(black);
        shoes6.setCountry(russia);
        shoes6.setGender(female);
        shoes6.setLining(leather);
        shoes6.setUp(rubber);
        shoes6.setStyle(fashion);
        shoes6.setSeason(aw2017);
        shoes6.setSole(rubber);
        shoes6.setName("Туфли");
        shoes6.setModel("OS202020");
        shoes6.setPrice("53500");
        shoes6.setShoesType(botinki);
        shoes6.setSizes(Arrays.asList(size40, size44, size43, size41, size42));

        Shoes shoes7 = new Shoes();
        shoes7.setBrand(clarks);
        shoes7.setColor(white);
        shoes7.setCountry(usa);
        shoes7.setGender(male);
        shoes7.setLining(leather);
        shoes7.setUp(leather);
        shoes7.setStyle(casual);
        shoes7.setSeason(aw2017);
        shoes7.setSole(rubber);
        shoes7.setName("Туфли");
        shoes7.setModel("OS202020");
        shoes7.setPrice("44000");
        shoes7.setShoesType(tufli);
        shoes7.setSizes(Arrays.asList(size40));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(shoes);
        session.persist(shoes1);
        session.persist(shoes2);
        session.persist(shoes3);
        session.persist(shoes4);
        session.persist(shoes5);
        session.persist(shoes6);
        session.persist(shoes7);
        session.getTransaction().commit();
        session.close();

//        ShoesDaoImpl shoesDao = new ShoesDaoImpl();
//        Map<String, List<String>> options = new HashMap<String, List<String>>();
//        options.put("brand", Arrays.asList(clarks.getName(), adidas.getName(), nike.getName()));
//        options.put("price", Arrays.asList("40000", "80000"));
//        options.put("shoesType", Arrays.asList(botinki.getName()));
//        options.put("sizes", Arrays.asList(size41.getSize()));
//        options.put("color", Arrays.asList(black.getName(), white.getName()));
//        options.put("gender", Arrays.asList(male.getName()));
//        shoesDao.getShoesByOptions(options);
    }
}
