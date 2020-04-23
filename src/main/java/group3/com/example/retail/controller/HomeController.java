package group3.com.example.retail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RestController
public class HomeController {
		
	@RequestMapping(value="/")
	public static String welcome(Model model) {
		//return "<h1>Welcome to Spring Boot</h1>";
		return "redirect:/product/home";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	


}