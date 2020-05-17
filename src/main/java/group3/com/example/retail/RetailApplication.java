package group3.com.example.retail;

import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import group3.com.example.retail.cart.*;
import group3.com.example.retail.product.ProductRepository;
import group3.com.example.retail.refund.Reason;
import group3.com.example.retail.refund.Refund;
import group3.com.example.retail.refund.RefundRepository;
import group3.com.example.retail.review.Review;
import group3.com.example.retail.review.ReviewRepo;

@SpringBootApplication
public class RetailApplication {
	

	@Bean
	public CommandLineRunner demoCart(CartRepository cartRepo, ProductRepository productRepo) {
		return (args) -> {
			// Get all Carts
			cartRepo.findAll().forEach((cart) -> { System.out.println(cart.toString()); });

			// Add item to a Cart
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}
}




