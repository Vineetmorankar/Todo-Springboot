package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {

//	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@RequestMapping("login")
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("myname", name);
//		logger.info("Request Parameter is {}", name);
//		return "login";
//	}
	
	private AuthenticationService authenticationService;
	
	
	
	public LoginController(AuthenticationService authenticationService) {
	super();
	this.authenticationService = authenticationService;
}

	@RequestMapping(value="login", method= RequestMethod.GET)
	public String goToLoginPage() {
		
		return "login";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(authenticationService.authenticate(name, password))
		{
		model.put("name", name);
		model.put("password", password);
		return "welcome";
		}
		
		model.put("errormsg", "Invalid Credentials, please try again!");
		return "login";
	}
}
