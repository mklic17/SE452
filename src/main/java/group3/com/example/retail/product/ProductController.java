package group3.com.example.retail.product;

import javax.validation.Valid;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.catalog.Catalog;
import group3.com.example.retail.category.Category;


@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/") // Return all Products
	public ModelAndView getAllProducts() { 
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/list");
		mnv.addObject("products", productService.getAllProducts());
		return mnv;
    }
	
	
	@GetMapping("/{Id}") // Returns a single product
	public ModelAndView getProduct(@PathVariable Long Id) {  
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/show");
		mnv.addObject("product", productService.getProduct(Id));
        return mnv;
	}
	

	@GetMapping({"/new"})
	public ModelAndView addProduct() {  // Adds a product to the DB with new values
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/newProductform");
		mnv.addObject("product", new Product());
		mnv.addObject("allCategories", getCategories()); 
		return mnv;
	}
	
	
	@PostMapping("/create") // POST mapping for new product
	  public ModelAndView createProduct(@Valid Product prod, BindingResult result) {  
		ModelAndView mnv = new ModelAndView();
	    if(result.hasErrors()) {
			mnv.setViewName("product/newProductform");
	        mnv.addObject("product", prod);
//	        mnv.addObject("categories", getCategories());
	        return mnv;
	    }		
	    productService.addProduct(prod);
	    mnv.addObject("product", productService.getProduct(prod.getId()));
	    mnv.setViewName("product/show");
	    return mnv;
	  }
	
	
	@GetMapping("/edit/{Id}")  // GET  method for editing a product
	public ModelAndView editProduct(@PathVariable Long Id) {
		ModelAndView mnv = new ModelAndView();
		Product prod= productService.getProduct(Id);
		mnv.setViewName("product/newProductform");
		mnv.addObject("product", prod);
//		mav.addObject("category", getCategories()); 
		return mnv;
	}
	
	
	@PutMapping("/edit/submit")  // PUT method for editing a product
	public ModelAndView updateProduct(@Valid Product prod, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
	    if(result.hasErrors()) {
			mnv.setViewName("product/editProductform");
	        mnv.addObject("product", prod);
	        mnv.addObject("allCategories", getCategories());
	        return mnv;
	    }		
	    productService.updateProduct(prod.getId(), prod);
	    
	    mnv.addObject("product", productService.getProduct(prod.getId()));
	    mnv.setViewName("product/show");
	    return mnv;
	}
	
	
	
//	@GetMapping("/delete/{Id}")
//	public ModelAndView deleteProduct(@PathVariable Long Id) {
//		ModelAndView mnv = new ModelAndView();
//		mnv.setViewName("product/delete")
//		return mnv;
//		
//	}

	
	@GetMapping("/delete/{Id}")
	public ModelAndView deleteProduct(@PathVariable Long Id) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("product/delete");
		mnv.addObject("product", productService.getProduct(Id));
//		productService.deleteProduct(prod.getId());
		return mnv;
	}
	
	
	@DeleteMapping("/delete/submit")
	public ModelAndView deleteProduct(@Valid Product prod, BindingResult result) {
		ModelAndView mnv = new ModelAndView();
		mnv.
		return mnv;

	}
	
	
	private Collection<Category> getCategories() {
		return Catalog.getCatalog().getAllStoreCategories();
	}
	
		
	
	
	
	
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
