package group3.com.example.retail.review;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Review")
public class Review {
  
  // not done, how it will basically go
  int[] totalRatings; // where all ratings for this product will be pulled from DB, may or may not end up being an array
  public int getAverageRating(int[] ratings) {
    
    int average;
    for (int i = 0; i < ratings.length; i++) {
      average+=ratings[i];
    }
    
    average = average/ratings.length;
    
    return average;
  }
  

}
