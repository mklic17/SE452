package group3.com.example.retail.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductToProductForm productToProductForm;
	
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
		return "product/list";
    }
	
	@RequestMapping(value="/product/{id}")
	public String getProduct(@PathVariable Long Id, Model model) { // getProduct()
        model.addAttribute("product", productService.getProduct((Id)));
        return "product/show";
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String addProduct(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "product/productform";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/product/{id}")
	public String updateProduct(@PathVariable Long Id, Model model) {
         Product product = productService.getProduct(Id);
		 ProductForm productForm = productToProductForm.convert(product);
		 model.addAttribute("productForm", productForm);
		 return "product/productform";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
	public String deleteProduct(@PathVariable Long Id) {
		productService.deleteProduct(Id);
		return "product/list";
	}

}
