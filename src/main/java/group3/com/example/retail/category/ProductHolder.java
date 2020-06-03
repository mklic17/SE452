package group3.com.example.retail.category;

import java.util.ArrayList;
import java.util.List;

import group3.com.example.retail.product.Product;
import lombok.Data;



@Data
public class ProductHolder {

	private Long theProduct;
	private Long categoryId;
	
	public ProductHolder(Long catId) {
		this.categoryId = catId;
	}
	
	
	public Long getCategoryId() {
		return this.categoryId;
	}
	
}
