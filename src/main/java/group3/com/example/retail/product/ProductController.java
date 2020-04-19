package group3.com.example.retail.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value="/products")   // getAllProducts()
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
    }
	
	@RequestMapping(value="/products/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) { // getProduct()
		return productService.getProduct(id);
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public void addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@RequestBody Product prod, @PathVariable Long Id) {
		 productService.updateProduct(Id, prod);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
	public void deleteProduct(@PathVariable Long Id) {
		productService.deleteProduct(Id);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/createTestProducts")
	public void createTestProducts() {
		productService.createTestProducts();
	}


}
