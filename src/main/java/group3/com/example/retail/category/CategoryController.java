package group3.com.example.retail.category;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.product.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;




@Controller
@RequestMapping(value="/category")   // getAllCategory()
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/")   // getAllCategory()
	public ModelAndView getAllCategory() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/list");
		mnv.addObject("categories", categoryService.getAllCategory());
		return mnv;
    }
	
	@GetMapping("/{Id}")
	public ModelAndView getCategory(@PathVariable Long Id) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/show");
		Category curr = categoryService.getCategory(Id);
		mnv.addObject("category", curr);
		mnv.addObject("products", curr.getProducts());
		return mnv;
	}
	
	
	@GetMapping("/new")
	public ModelAndView createCategory() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/newCategoryForm");
		mnv.addObject("category", new Category());
		return mnv;
	}
	
	@PostMapping("/new")
	public ModelAndView postCategory(@Valid Category cat, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
	    if(result.hasErrors()) {
			mnv.setViewName("category/newCategoryForm");
	        mnv.addObject("category", cat);
//	        mnv.addObject("categories", getCategories());
	        return mnv;
	    }		
	    categoryService.addCategory(cat);
		mnv.addObject("categories", categoryService.getAllCategory());
	    mnv.setViewName("category/list");
	    return mnv;
	}
	
	//
	public String getNameFromID(Long Id) {
		return categoryService.getCategory(Id).getName();
	}
//

}