package group3.com.example.retail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
		
	@RequestMapping(value="/")
	public static String welcome() {
		return "<h1>Welcome to Spring Boot</h1>";
	}
	
//	@RequestMapping(value="/error")
//	public static String error() {
//		return "<h1>You enxperienced an Error</h1>";
//	}

}