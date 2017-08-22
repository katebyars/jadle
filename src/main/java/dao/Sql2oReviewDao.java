package dao;
import models.Review;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oReviewDao implements ReviewDao {

    private final Sql2o sql2o;

    public Sql2oReviewDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(Review review) {
            String sql = "INSERT INTO restaurants (writtenby, rating, createdat, restaurantid) VALUES (:writtenby, :rating, :createdat, :restaurantid)";
            try (Connection conn = sql2o.open()) {
                int id = (int) conn.createQuery(sql)
                        .addParameter("writtenby", review.getWrittenBy())
                        .addParameter("rating", review.getRating())
                        .addParameter("createdat", review.getCreatedAt())
                        .addParameter("restaurantid", review.getRestaurantId())
                        .addColumnMapping("WRITTENBY", "writtenby")
                        .addColumnMapping("RATING", "rating")
                        .addColumnMapping("CREATEDAT", "createdat")
                        .addColumnMapping("RESTAURANTID", "restaurantid")
                        .executeUpdate()
                        .getKey();
                review.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
    }

}
