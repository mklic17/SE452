package group3.com.example.retail;


import java.sql.Timestamp;
import java.util.List;

import group3.com.example.retail.cart.*;
import group3.com.example.retail.catalog.Catalog;
import group3.com.example.retail.product.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import group3.com.example.retail.refund.Reason;
import group3.com.example.retail.refund.Refund;
import group3.com.example.retail.refund.RefundRepository;

@SpringBootApplication
public class RetailApplication {


	 @Bean
	    public CommandLineRunner returnItem(CartRepository repository, OrdersRepo orderrepo) {
	        return (args) -> {

	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
//		
	}

}




