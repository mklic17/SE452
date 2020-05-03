package group3.com.example.retail;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import group3.com.example.retail.cart.OrdersRepo;
import group3.com.example.retail.refund.Refund;
import group3.com.example.retail.refund.RefundRepository;

@SpringBootApplication
public class RetailApplication {
	
	
	 @Bean
	    public CommandLineRunner returnItem(RefundRepository repository, OrdersRepo orderrepo) {
	        return (args) -> {
	            // save a review
	        	
	        	Refund refund = new Refund();
	        	refund.setOrdernumber("000002");
	        	refund.setProductname("Soccer Ball");
	      
	        	repository.save(refund);
	        	
	        	orderrepo.deleteById(refund.getOrdernumber());
	      
	        	
	        
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);

	}

}
