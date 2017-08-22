package dao;

import models.Foodtype;
import models.Restaurant;

import java.util.List;

public interface RestaurantDao {

    //CREATE
    void add(Restaurant restaurant);
    void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype);

    //READ
//    List<Restaurant> getAll();
    List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId);


//    Restaurant findById(int id);
//    void update(int id, String name, String adress, String zipcde, String phone, String website, String email, String image);
//    void deleteById(int id);
}
