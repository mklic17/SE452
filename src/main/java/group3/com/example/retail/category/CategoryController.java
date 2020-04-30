package group3.com.example.retail.category;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;




@Controller
@RequestMapping(value="/category")   // getAllCategory()

public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/")   // getAllCategory()
	public ModelAndView getAllCategory() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/listAllCategory");
		mnv.addObject("categories", categoryService.getAllCategory());
		return mnv;
    }
	
	public String getNameFromID(Long Id) {
		return categoryService.getCategory(Id).getName();
	}


}
//