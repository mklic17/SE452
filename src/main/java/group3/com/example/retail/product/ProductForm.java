package group3.com.example.retail.product;

import lombok.Data;

@Data
public class ProductForm {
	// matches the Product fields
	
	private Long Id;
	private String name;
	private String description;
	private double price;

}
