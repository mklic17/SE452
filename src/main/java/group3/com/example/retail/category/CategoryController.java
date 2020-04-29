package group3.com.example.retail.category;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;




@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/category")   // getAllCategory()
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
    }

	
}
