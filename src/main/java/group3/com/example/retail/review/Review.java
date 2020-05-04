package group3.com.example.retail.review;


import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity

public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productid;
	private String userID;
	private String comment;


}
