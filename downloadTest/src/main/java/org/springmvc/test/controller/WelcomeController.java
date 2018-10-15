package org.springmvc.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(WelcomeController.class);
	
	@RequestMapping(value = "/dept1/{name}", method = RequestMethod.GET)
	public String welcome(@PathVariable String name, Model model){
		
		logger.info("inside welcome()");
		model.addAttribute("welcome", "Welcome user " + name + " from dept1");
		return "welcome";
		
		
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response){
		
		
	}
	

}
