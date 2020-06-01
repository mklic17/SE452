package group3.com.example.retail;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import group3.com.example.retail.catalog.Catalog;
import group3.com.example.retail.category.Category;
import group3.com.example.retail.category.CategoryService;
import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductService;


@Component
public class Application implements InitializingBean {
	
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private CategoryService categoryService; 
	
	@Autowired
	private ProductService productService; 

	public void afterPropertiesSet() {
		Catalog storefront = Catalog.getCatalog(productService.getAllProducts(), categoryService.getAllCategory());
		Collection<Category> catCol = storefront.getAllStoreCategories();
		Collection<Product> prodCol = storefront.getAllProducts();
		
		for(Category cat : catCol) {
			System.out.println("CategoryName: " + cat.getName());
		}
		
		for(Product prod : prodCol) {
			System.out.println("ProductName: " + prod.getName());
		}
	}
	

}