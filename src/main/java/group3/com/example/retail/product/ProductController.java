package group3.com.example.retail.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping(method={RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT} )
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductToProductForm productToProductForm;
	
	
	@GetMapping("/")
	public ModelAndView getAllProducts() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/list");
		mnv.addObject("products", productService.getAllProducts());
		return mnv;
    }
	
	@GetMapping(value="/{Id}")
	public ModelAndView getProduct(@PathVariable Long Id) { // getProduct()
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/show");
		mnv.addObject("product", productService.getProduct(Id));
        return mnv;
	}
	
	@GetMapping({"/new"})
	public ModelAndView addProduct() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/newProductform");
		mnv.addObject("product", new Product());
//		mav.addObject("category", getCategories()); 
		return mnv;
	}
	
	@PostMapping("/create")
	  public ModelAndView createUser(@Valid Product prod, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
	    if(result.hasErrors()) {
//	       	logger.info("Validation errors while submitting form.");
			mnv.setViewName("product/newProductform");
	        mnv.addObject("product", prod);
//	        mnv.addObject("allProfiles", getProfiles());
	        return mnv;
	    }		
	    productService.addProduct(prod);
	    mnv.addObject("product", productService.getProduct(prod.getId()));
	    mnv.setViewName("product/show");
//	    logger.info("Form submitted successfully.");	    
	    return mnv;
	  }
	//
	
//	@RequestMapping(method=RequestMethod.PUT, value="/product/{id}")
//	public String updateProduct(@PathVariable Long Id, Model model) {
//         Product product = productService.getProduct(Id);
//		 ProductForm productForm = productToProductForm.convert(product);
//		 model.addAttribute("productForm", productForm);
//		 return "product/productform";
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
//	public String deleteProduct(@PathVariable Long Id) {
//		productService.deleteProduct(Id);
//		return "product/list";
//	}

}
