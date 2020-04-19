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
	public Optional<Product> getProduct(Long Id) { 
		return productRepository.findById(Id);
	} 
	
	
	// Adds a product to the Database
	public void addProduct(Product prod) {
		productRepository.save(prod);
	}
	
	
	// Updates a product with the information if it exists or creates a new product
	public void updateProduct(Long Id, Product prod) {
		productRepository.save(prod);
	}
	
	
	
	// Removes a product from the Database 
	public void deleteProduct(Long Id) {
		productRepository.deleteById(Id);
	}
	
	
	public void createTestProducts() {
		Product p1 = new Product("Baseball", "This is a baseball", 19.99);
		Product p2 = new Product("basketball", "This is a basketball", 49.99);
		Product p3 = new Product("soccer ball", "This is a soccer ball", 29.99);
		addProduct(p1);
		addProduct(p2);
		addProduct(p3);
	}

}
