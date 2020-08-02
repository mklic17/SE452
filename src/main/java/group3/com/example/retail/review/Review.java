package group3.com.example.retail.review;



import lombok.Data;
import javax.persistence.*;


@Data
@Entity
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productId;
//	private String userID;
	private int rating;
	private String comment;

}
//