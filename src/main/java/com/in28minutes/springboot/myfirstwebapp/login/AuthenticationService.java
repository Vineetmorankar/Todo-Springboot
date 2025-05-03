package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name, String password)
	{
		boolean isvalidname = name.equalsIgnoreCase("Vineet");
		boolean isvalidpass = password.equalsIgnoreCase("Morankar");
		
		return isvalidname && isvalidpass;
	}
}
