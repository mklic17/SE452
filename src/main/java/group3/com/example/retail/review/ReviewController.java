package group3.com.example.retail.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	
	@GetMapping({"/", ""})
	public ModelAndView getReview() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("review/review");
		return mnv;
	}
	//
	
	

}
