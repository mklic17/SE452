package group3.com.example.retail.category;

public class CategoryFactory {
	
	public static Category createCategory() {
		return new Category();
	}
	
	public static Category createCategory(String name, Long parent) {
		return new Category(name, parent);
	}
	
	
//	public static ArrayList<Category> getCategory() {
//		return CategoryController.getAllCategories();
//	}
//	
	

}
