package group3.com.example.retail.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; // extends CrudRepository
	
	
	// Returns a List of All Products that is currently in the database
	public List<Product> getAllProducts() { 
		ArrayList<Product> productList = new ArrayList<Product>();
		for(Product prod : productRepository.findAll()) {
			productList.add(prod);
		}
		return productList;
	}
	
	
	// Returns a single Product if it Exist or returns NULL
	public Product getProduct(Long Id) { 
		return productRepository.findById(Id).orElse(null);
	} 
	
	
	// Adds a product to the Database
	public void addProduct(Product prod) {
		productRepository.save(prod);
	}
	
	
	// Updates a product with the information if it exists or creates a new product
	public void updateProduct(Long Id, Product prod) {
		// need to do a find first
		// Then update
		// then save
		productRepository.save(prod);
	}
	
	
	
	// Removes a product from the Database 
	public void deleteProduct(Long Id) {
		productRepository.deleteById(Id);
	}
	


}
