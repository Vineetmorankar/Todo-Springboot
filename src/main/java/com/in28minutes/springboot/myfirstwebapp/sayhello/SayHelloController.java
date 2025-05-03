package com.in28minutes.springboot.myfirstwebapp.sayhello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String Sayhello() {
		return "Hello, What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public StringBuffer Sayhellohtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("My firstWeb");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h2>");
		sb.append("Hello, What are you learning today..?");
		sb.append("</h2>");
		sb.append("</body>");
		sb.append("</html>");

		return sb;
	}
	
	@RequestMapping("say-hello-jsp")
	public String SayhelloJsp() {
		return "sayHello";
	}
}
