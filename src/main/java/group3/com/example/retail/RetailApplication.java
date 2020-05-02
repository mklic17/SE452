package group3.com.example.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import group3.com.example.retail.catalog.Catalog;

@SpringBootApplication
public class RetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
//		Catalog storefront = Catalog.getCatalog();
	}

}
