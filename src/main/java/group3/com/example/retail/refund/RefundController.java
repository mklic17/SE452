package group3.com.example.retail.refund;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.product.Product;

@Controller
@RequestMapping("refund")
public class RefundController {
	
	
//	@RequestMapping("/refund/{Id}")
//	public ModelAndView getRefundPage(@PathVariable Long Id) {
//		ModelAndView mnv = new ModelAndView();
//		mnv.setViewName("refund/form");
////		mnv.setObject("Order", getOrder(Id));
//		return mnv;
//	}

	
	@GetMapping("/")
	public ModelAndView getRefundPage() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("review/form");
		mnv.addObject("Refund", new Refund());
		return mnv;
	}
	
	@PostMapping("/createRefund")
	public ModelAndView submit(@Valid Refund ref, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
//	    if(result.hasErrors()) {
//			mnv.setViewName("refund/form");
//	        mnv.addObject("refund", ref);
//	        return mnv;
//	    }	
		mnv.setViewName("other/home");

//	    productService.updateProduct(prod.getId(), prod);
	    // refundService.update()
	    return mnv;
	}

	

}
//