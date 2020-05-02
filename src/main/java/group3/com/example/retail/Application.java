package group3.com.example.retail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import group3.com.example.retail.catalog.Catalog;
import group3.com.example.retail.category.CategoryService;


@Component
public class Application implements InitializingBean {
	
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    @Autowired
   	private CategoryService catService;
	
	public void afterPropertiesSet() {
	      // do some initialization work
		
		logger.info("initializing Catelog");
		Catalog storefront = Catalog.getCatalog();
		
		
	}
	
	

}
