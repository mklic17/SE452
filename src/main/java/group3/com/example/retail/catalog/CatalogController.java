package group3.com.example.retail.catalog;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import group3.com.example.retail.cart.CartService;
import group3.com.example.retail.category.Category;
import group3.com.example.retail.product.Product;

@Controller
public class CatalogController {
	
	private static Catalog catalog = Catalog.getCatalog(); // 
	
	@Autowired
	private CartService cartService;

	
	@GetMapping({"/admin"}) // Return all Products
	public ModelAndView adminDashboard() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("admin/adminDashboard");
		return mnv;
	}

	
	@GetMapping({"", "/home", "index", "/"}) // Return all Products
	public ModelAndView home() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("home/home");
		mnv.addObject("categorys", catalog.getAllStoreCategories());
		mnv.addObject("products", catalog.getAllProducts() );
		mnv.addObject("heading", " Welcome to Ecommerce");
		return mnv;
	}
	
	
	@GetMapping({"/{categoryName}", "/{categoryName}/"}) // Return all Products in Category
	public ModelAndView getCategory(@PathVariable String categoryName) {
		ModelAndView mnv = new ModelAndView();
		Category cat = catalog.getCategoryByName(categoryName);
		mnv.setViewName("home/home");
		mnv.addObject("categorys", catalog.getAllStoreCategories());
		Set<Product> prodList = cat.getProducts();
		mnv.addObject("products", prodList);
		mnv.addObject("heading", cat.getName());
		return mnv;
	}
	
	
	@GetMapping("/product/{Id}") // Returns a single product
	public ModelAndView getProduct(@PathVariable Long Id) {  
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/show");
		mnv.addObject("product", catalog.getProductById(Id));
        return mnv;
	}
	
	
	@PostMapping("/search")
	public ModelAndView searchProduct(@RequestParam String content) {	
		ModelAndView mnv = new ModelAndView();
		Product prod = catalog.getProductByName(content);

		if( prod != null) {
		    mnv.setViewName("product/show");
		    mnv.addObject("product", prod);
		    return mnv;
		} 
		
		mnv.setViewName("home/home");
		mnv.addObject("categorys", catalog.getAllStoreCategories());
		mnv.addObject("products", catalog.getAllProducts() );
		mnv.addObject("heading", "No Results for " + content);
		return mnv;
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle(Exception ex) {
		 ModelAndView mnv = new ModelAndView();
		 mnv.setViewName("error/404");
		 mnv.addObject("message", ex.getMessage());
		 return mnv;
    }
	
	
	private static Set<Product> getAllProductsInCategory(String categoryId) {
		return catalog.getAllProductsInCategory(categoryId);
	}
	
	
	public static void rebuildCatalog(List<Product> prodList, List<Category> catList) {
		catalog = null;
		catalog = Catalog.rebuildCatalog(prodList, catList);
	}
	
	
	///////////////////////////////////////////////////////////////
	//                     Thomas
	///////////////////////////////////////////////////////////////
	@PostMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable Long productId) {
		System.out.println(productId);
		// TODO: Remove hardcoded user ID
		cartService.addProductToCart(productId, 1);
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/show");
		mnv.addObject("product", catalog.getProductById(productId));
		return "redirect:/product/{productId}";
	}
	
	

}
