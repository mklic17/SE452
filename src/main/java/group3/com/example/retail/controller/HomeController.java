package group3.com.example.retail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
		
	@GetMapping({"/", "index", "home"})
	public static String welcome(Model model) {
		return "other/home";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	
	// TEST: https://hellokoding.com/spring-boot-hello-world-example-with-thymeleaf/
	@GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "other/hello";
    }


}