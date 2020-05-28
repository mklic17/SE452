package group3.com.example.retail.category;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;




@Controller
@RequestMapping(value="category")   // getAllCategory()
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	
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
		
		String parent = null;
		if (curr.getParent() != null) {
			parent = categoryService.getCategory(curr.getParent()).getName();
		} else {
			parent = "Already a Root";
		}
		

		mnv.addObject("parentCategory", parent);
		mnv.addObject("category", curr);
		mnv.addObject("products", curr.getProducts());
		return mnv;
	}
	
	
	@GetMapping("/new")
	public ModelAndView createCategory() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/newCategoryForm");
		mnv.addObject("category", new Category());
		mnv.addObject("allProducts", productService.getAllProducts());
		return mnv;
	}
	
	
	@PostMapping("/new")
	public ModelAndView postCategory(@Valid Category cat, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
	    if(result.hasErrors()) {
			mnv.setViewName("category/newCategoryForm");
	        mnv.addObject("category", cat);
	        return mnv;
	    }		
	    categoryService.addCategory(cat);
	    mnv.setViewName("category/list");
		mnv.addObject("categories", categoryService.getAllCategory());
	    return mnv;
	}
	
	@GetMapping("/edit/{Id}")
	public ModelAndView editCategory(@PathVariable Long Id) {
		ModelAndView mnv = new ModelAndView();
		Category cat = categoryService.getCategory(Id);
		// if exists
		mnv.setViewName("category/newCategoryform");
		mnv.addObject("category", cat);
		return mnv;
	}
	
//	@PutMapping("/edit/submit") 
//	public ModelAndView updateCategory(@Valid Category cat, BindingResult result) {
//		ModelAndView mnv = new ModelAndView();
//		if(result.hasErrors()) {
//			mnv.setViewName("category/editCategoryForm");
//			mnv.addObject("category", cat);	  
//			return mnv;
//		}
//		
//		categoryService.updateCategory(cat.getId(), cat);
//		mnv.setViewName("category/show");
//		mnv.addObject("category", categoryService.getCategory(cat.getId()));
//		
//		return mnv;
//	}
	
	@GetMapping("/delete/{Id}")
	public ModelAndView deleteCategory(@PathVariable Long Id) {
		ModelAndView mnv = new ModelAndView();
		Category cat = categoryService.getCategory(Id);
		if(cat != null) {
			categoryService.deleteCategory(Id);
		}		
		mnv.setViewName("category/list");
		mnv.addObject("categories", categoryService.getAllCategory());
		return mnv;
	}
	
	
	@PostMapping("/addProductAssignment")
	public ModelAndView postProductAssignment(Category cat) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("category/show/");
		
		return mnv;
	}
	

	public String getNameFromID(Long Id) {
		return categoryService.getCategory(Id).getName();
	}


}