package group3.com.example.retail.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("cart")
@Controller
public class CartController {
	// go to 'localhost/7996/cart/'
	@GetMapping("/") // Return cart
	public ModelAndView getCart() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("cart/cart");
//		mnv.setObject("carts", getTheCurrentCart()); // (parm=Static reference to somethign I have declr
		return mnv;		
	}
}
