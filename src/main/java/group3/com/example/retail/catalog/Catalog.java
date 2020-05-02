package group3.com.example.retail.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import group3.com.example.retail.category.Category;
import group3.com.example.retail.category.CategoryFactory;


// No Lombok, No Database, created at the start of the program and when maunally forced to rebuild
public class Catalog {

	private static Catalog storefrontCatalog = null; // singleton Constructor
	private static Map<Long, Category> categoryMap;
	private static Category head;


//	// Public way to create catalog, Singleton Allows only 1 to be constructed
	public static Catalog getCatalog(List<Category> list) {
		if (storefrontCatalog == null) {
			storefrontCatalog = new Catalog(list);
		}
		return storefrontCatalog;
	}
	
	
	//
	public static Catalog getCatalog() {
		if (storefrontCatalog == null) {
			storefrontCatalog = new Catalog(null);
		}
		return storefrontCatalog;
	}
	
	
	// private constructor
	private Catalog(List<Category> list) {
		categoryMap = new HashMap<Long, Category>();
		
		Catalog.head = CategoryFactory.createCategory("main", Long.valueOf(-1)); // set main, default head
		
		if(list != null) {
			for(Category cat : list) {
				System.out.println("Building Catalog " + cat.getName());
	            Long parentId = cat.getParent();
	            
	            if (parentId == 0 || parentId == null) {
	            	Category temp = CategoryFactory.createCategory(cat.getName(), head.getId());
	                categoryMap.put(temp.getId(), temp);
	            } 
	            else {
	                categoryMap.put(cat.getId(), cat);
	            }
	        }
//			buildTheCatalogNavigation(head);
		}
	}
	
	public Collection<Category> getAllStoreCategories() {
		return categoryMap.values();
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
