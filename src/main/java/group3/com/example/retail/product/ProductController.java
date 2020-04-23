package group3.com.example.retail.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductToProductForm productToProductForm;
	
	
	@RequestMapping(value="/products")   // getAllProducts()
	public List<Product> getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
		return productService.getAllProducts();
    }
	
	@RequestMapping(value="/products/{id}")
	public String getProduct(@PathVariable Long Id, Model model) { // getProduct()
        model.addAttribute("product", productService.getProduct((Id)));
        return "product/show";

	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "product/productform";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public String updateProduct(@PathVariable Long Id, Model model) {
         Product product = productService.getProduct(Id);
		 ProductForm productForm = productToProductForm.convert(product);
		 model.addAttribute("productForm", productForm);
		 return "product/productform";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
	public String deleteProduct(@PathVariable Long Id) {
		productService.deleteProduct(Id);
		return "redirect:/product/list";
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/createTestProducts")
	public void createTestProducts() {
		productService.createTestProducts();
	}


}
