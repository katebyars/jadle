package dao;
import org.sql2o.Connection;
import models.Foodtype;
import models.Restaurant;
import org.sql2o.Sql2o;
import dao.Sql2oRestaurantDao;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.Sql2oException;

public class Sql2oRestaurantDao implements RestaurantDao {

    private final Sql2o sql2o;

    public Sql2oRestaurantDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Restaurant restaurant) {
    String sql = "INSERT INTO restaurants (name, address, zipcode, phone, website, email, image) VALUES (:name, :address, :zipcode, :phone, :website, :email, :image)";
        try (Connection conn = sql2o.open()) {
        int id = (int) conn.createQuery(sql)
                .addParameter("name", restaurant.getName())
                .addParameter("address", restaurant.getAddress())
                .addParameter("zipcode", restaurant.getZipcode())
                .addParameter("phone", restaurant.getPhone())
                .addParameter("website", restaurant.getWebsite())
                .addParameter("email", restaurant.getEmail())
                .addParameter("image", restaurant.getImage())
                .addColumnMapping("NAME", "name")
                .addColumnMapping("ADDRESS", "address")
                .addColumnMapping("ZIPCODE", "zipcode")
                .addColumnMapping("PHONE", "phone")
                .addColumnMapping("WEBSITE", "website")
                .addColumnMapping("EMAIL", "email")
                .addColumnMapping("IMAGE", "image")
                .executeUpdate()
                .getKey();
        restaurant.setId(id);
    } catch (Sql2oException ex) {
        System.out.println(ex);
    }
}

    @Override
    public void addRestaurantToFoodType (Restaurant restaurant, Foodtype foodtype) {
        //stuff
    }

    @Override
    public List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId) {
        List<Foodtype> foodtypes = new ArrayList<>();
        return foodtypes;
    }
}
