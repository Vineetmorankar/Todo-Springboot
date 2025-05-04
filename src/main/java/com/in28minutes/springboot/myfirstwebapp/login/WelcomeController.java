package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@RequestMapping("login")
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("myname", name);
//		logger.info("Request Parameter is {}", name);
//		return "login";
//	}
//	

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String goToWelcomPage(ModelMap model) {
		model.put("name", getLoggedInUser());
		return "welcome";
	}
	
	private String getLoggedInUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
}
