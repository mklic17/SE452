package group3.com.example.retail;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import group3.com.example.retail.catalog.Catalog;
import group3.com.example.retail.product.*;

public class Application implements CommandLineRunner {
	
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
	private ProductRepository prodRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("initializing Products");
		Catalog storefront = Catalog.getCatalog();


	}

}
//