package group3.com.example.retail.refund;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.product.Product;


@Controller
//@RequestMapping("/refund")
public class RefundController {
	
	

	 @Autowired
	    private RefundRepository repo;
	    public RefundController() { }
	
	@GetMapping("refund")
	public String form(Model model) {
		
		model.addAttribute("refund",new Refund());
	
		
		return "refund/form";
	}
	
	@PostMapping("refund")
	public String confirm(@ModelAttribute("refund") Refund refund, BindingResult bindingResult) {
		
		repo.save(refund);
		  
		return "refund/refundConfirm";
	}

	

}
