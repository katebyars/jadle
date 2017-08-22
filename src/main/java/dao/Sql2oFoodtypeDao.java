package dao;

import models.Foodtype;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oFoodtypeDao implements FoodtypeDao {

    private final Sql2o sql2o;

    public Sql2oFoodtypeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(Foodtype foodtype) {
            String sql = "INSERT INTO foodtypes (name) VALUES (:name)";
            try (Connection conn = sql2o.open()) {
                int id = (int) conn.createQuery(sql)
                        .addParameter("name", foodtype.getName())
                        .addColumnMapping("NAME", "name")
                        .executeUpdate()
                        .getKey();
                foodtype.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
    }

    @Override
    public void
    addFoodtypeToRestaurant (Foodtype foodtype, Restaurant restaurant){
        //stuff
    }

    @Override
    public List<Restaurant> getAllRestaurantsForAFoodtype(int foodtypeId) {
        List<Restaurant> restaurants = new ArrayList<>();
        return restaurants;
    }
}
