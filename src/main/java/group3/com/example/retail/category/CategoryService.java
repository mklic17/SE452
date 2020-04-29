package group3.com.example.retail.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	// getAllCatalogs
	public List<Catalog> getAllCatalogs() {
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		for(Catalog cat : catalogRepository.findAll())
			catalogList.add(cat);
		return catalogList;
	}
	
	// Returns a single catalog if it Exist or returns NULL
	public Optional<Catalog> getCatalog(Long Id) { 
		return catalogRepository.findById(Id);
	} 
	
	// Adds a catalog to the Database
	public void addCatalog(Catalog cat) {
		catalogRepository.save(cat);
	}
	
	// Updates a catalog with the information if it exists or creates a new catalog
	public void updateCatalog(Long Id, Catalog cat) {
		catalogRepository.save(cat);
	}
	
	
	// Removes a catalog from the Database 
	public void deleteCatalog(Long Id) {
		catalogRepository.deleteById(Id);
	}

	
	//
}
