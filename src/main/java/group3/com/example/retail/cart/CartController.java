package group3.com.example.retail.cart;

import group3.com.example.retail.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;

	// go to 'localhost/7996/cart/'
	@GetMapping("/cart")
	public ModelAndView getCart() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("cart/cart");
		mnv.addObject("user", "Fake User");
		// Put all products in cart
		// TODO: Get real products in cart from table
		mnv.addObject("products", productService.getAllProducts());
		return mnv;		
	}

	@GetMapping("/checkout")
	public ModelAndView getCheckout() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("cart/checkout");
		// TODO: Get real products in cart from table
		mnv.addObject("products", productService.getAllProducts());
		return mnv;
	}
}
