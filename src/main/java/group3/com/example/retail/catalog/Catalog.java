package group3.com.example.retail.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import group3.com.example.retail.category.Category;
import group3.com.example.retail.product.Product;


// No Lombok, No Database, created at the start of the program and when maunally forced to rebuild
public class Catalog {


	
	private static Catalog storefrontCatalog = null; // singleton Constructor	
	
	private Map<Long, ArrayList<Long>> catalogMap = null;      // Category ID (parent) --> List<Category Id's>  (children)
	private Map<Long, Category> categoryMap = null;            // Category ID --> Category 
	private Map<Long, Product> productMap = null;              // Product ID --> Product
	
															   // Product(
	
	public static Catalog getCatalog(List<Product> prodList, List<Category> catList) {
		if (storefrontCatalog == null) {
			storefrontCatalog = new Catalog(prodList, catList);
		}
		return storefrontCatalog;
	}
	
	public static Catalog getCatalog() {
		return storefrontCatalog;
	}
	
	
	public static void rebuildCatalog(List<Product> prodList, List<Category> catList) {
		storefrontCatalog = null;
		storefrontCatalog = new Catalog(prodList, catList);
	}
	
	
	// private constructor
	private Catalog(List<Product> prodList, List<Category> catList) {
		
//		categoryFactory = CategoryFactory.getCategoryFactory();
//		productFactory = new ProductFactory(); 
		
		catalogMap = new HashMap<Long, ArrayList<Long>>();  
		categoryMap = new HashMap<Long, Category>();
		productMap = new HashMap<Long, Product>();
		
		// initalize productMap
		for(Product prod : prodList) {
			productMap.put(prod.getId(), prod);
		}
		
		// initialize categoryMap
		for(Category cat : catList) {
			categoryMap.put(cat.getId(), cat);
			
			// initalize Catalog
			if (catalogMap.containsKey(cat.getId())) { // if the category is in the catalog append to the list
				List<Long> liCat = catalogMap.get(cat.getId());
				liCat.add(cat.getId());
			} else { 
				catalogMap.put(cat.getId(), new List<long>());
			}
		}
		
		// initialize CatalogMap
		//
		
	}
	
	public Collection<Category> getAllStoreCategories() {
		return categoryMap.values();
	}
	
	public Collection<Product> getAllProducts() {
		return productMap.values();
	}
	
	
	public List<Product> getAllProductsInCategory(String categoryId) {
		// check to see if there is products in the Category
		List <Product> productList = new ArrayList<Product>();
		Category cat = categoryMap.get(categoryId);
		for(Long prodId : cat.getProductAssignments()) {
			productList.add(productMap.get(prodId));
		}
		return productList;
	}
	



	
//	private void buildTheCatalogNavigation(Category currRoot) {
//		ArrayList<Category> catList = getParentCategories(currRoot.getId());
//		CategoryFactory.setChildCategoryList(currRoot, catList);
//	    	if (catList.size() == 0) {
//	    		return;
//	     }
//	     for (Category cat : catList) {
//	    	 buildTheCatalogNavigation(cat);
//	     }
//	}
	

//	private ArrayList<Category> getParentCategories(Long parentId) {
//		ArrayList<Category> theArrayList = new ArrayList<Category>();
//		for(Category cat : categoryMap.values()) {
//			if(cat.getParentCategoryId() == parentId) {
//				theArrayList.add(cat);
//			}
//		}
//		return theArrayList;
//	}
	

//	 private static void printHierarchyTree(Category localRoot, int level) {
//		 for (int i = 0; i < level; i++) {
//			 System.out.print("\t");
//		 }
//		 System.out.println(localRoot.getName());
//
//		 List<Category> subordinates = localRoot.getChildCategoryList();
//		 System.out.print(" ");
//		 for (Category e : subordinates) {
//			 printHierarchyTree(e, level + 1);
//		 }
//	 }

}
