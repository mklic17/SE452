package group3.com.example.retail.catalog;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;




@RestController
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value="/catalogs")   // getAllCatalogs()
	public List<Catalog> getAllCatalogss() {
		return catalogService.getAllCatalogs();
    }

	
}
