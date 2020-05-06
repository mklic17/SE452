package group3.com.example.retail;


import java.sql.Timestamp;

import group3.com.example.retail.cart.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import group3.com.example.retail.refund.Reason;
import group3.com.example.retail.refund.Refund;
import group3.com.example.retail.refund.RefundRepository;
import group3.com.example.retail.review.Review;
import group3.com.example.retail.review.ReviewRepo;

@SpringBootApplication
public class RetailApplication {

//	@Bean
//		public CommandLineRunner writeReview(ReviewRepo reviewRepo) {
//		return (args) -> {
//			
//			Review review = new Review();
//			review.setProductid("34343");
//			review.setUserID("45");
//			review.setComment("I Hate This Product");
//			
//			reviewRepo.save(review);
//			
//		};
//		
//	}
	
//	 @Bean
//	    public CommandLineRunner returnItem(RefundRepository repository, OrdersRepo orderrepo) {
//	        return (args) -> {
//	            // save a review
//	        	
//	        	Refund refund = new Refund();
//	        	refund.setOrdernumber("1");
//	        	refund.setProductname("Soccer Ball");
//	        	Reason r = new Reason("joe", "did not like this ball");
//	        	
//	        	refund.setReason(r);
//	        	
//	        	repository.save(refund);
//	        	
//	        	if (orderrepo.existsById(1)==false) {
//	        	
//	        		orderrepo.deleteById(Integer.parseInt(refund.getRefundid())-1);
//	        	}else {
//	        		orderrepo.deleteById(Integer.parseInt(refund.getOrdernumber()));
//	        	}
//	        	///---------------Below used for testing only-------///
//	        	
//	        	Orders o = new Orders();
//	        	o.setDateplaced(new Timestamp(System.currentTimeMillis()));
//	        	o.setPrice(29.99);
//	        	o.setProductID("bb");
//	        	o.setProductname("Soccer Ball");
//	        	//o.setId(000002);
//	        	orderrepo.save(o);	      
//	        	
//	        };
//	    }

	
	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);	
	}

}




