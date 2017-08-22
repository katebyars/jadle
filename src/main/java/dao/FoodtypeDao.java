package dao;


import com.sun.org.apache.regexp.internal.RE;
import models.Foodtype;
import models.Restaurant;

import java.util.List;

public interface FoodtypeDao {

     //CREATE
     void add(Foodtype foodtype);
     void addFoodtypeToRestaurant (Foodtype foodtype, Restaurant restaurant);


     //READ
//     List<Foodtype> getAll();
     List<Restaurant> getAllRestaurantsForAFoodtype (int foodtypeId);


//     void findById(int id);
//     void update();
//     void deleteById();
}
