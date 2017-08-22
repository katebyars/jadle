package dao;

import com.sun.org.apache.regexp.internal.RE;
import models.Foodtype;
import models.Restaurant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static enums.DiningStyle.CASUAL;
import static org.junit.Assert.*;


public class Sql2oFoodtypeDaoTest {

    private
    Sql2oFoodtypeDao foodtypeDao;
    private Connection con;
    Sql2oRestaurantDao restaurantDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //helper1
    public Restaurant setupRestaurant () {
        Restaurant newRestaurant = new Restaurant("Bennihanna", "1234 Easy Street", "40040", "4042025555", CASUAL);
        return newRestaurant;
    }

    //helper2
    public Restaurant altRestaurant () {
        Restaurant newRestaurant = new Restaurant("Poke Bowl", "1234 Easy Street", "40040", "4042025555", CASUAL);
        return newRestaurant;
    }

    //helper3

    public Foodtype setUpNewFoodtype () {
        Foodtype newFoodtype = new Foodtype("Asian");
    }

    @Test
    public void addFoodTypeToRetaurantAddsTypeCorrectly() throws Exception {

        Restaurant testRestaurant = setupRestaurant();
        Restaurant altRestaurant = altRestaurant();
        restaurantDao.add(testRestaurant);
        restaurantDao.add(altRestaurant);

        Foodtype testFoodType =  setUpNewFoodtype();
        foodtypeDao.add(testFoodType);

        foodtypeDao.addFoodtypeToRestaurant(testFoodType, testRestaurant);
        foodtypeDao.addFoodtypeToRestaurant(testFoodType, altRestaurant);

        assertEquals(2, foodtypeDao.getAllRestaurantsForAFoodtype(testFoodType.getId()).size());
    }

}