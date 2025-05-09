package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}



	@RequestMapping("list-todos")
	public String ListAllTodos(ModelMap model)
	{
		String username = getLoggedInUser(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listtodos";
	}

	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String goToAddTodo(ModelMap model)
	{
		String username = getLoggedInUser(model);
		Todo todo = new Todo(0,username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String AddNewTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		String username = getLoggedInUser(model);
		todoService.addTodo(username, todo.getDescription(), todo.getTargetdate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo")
	public String goToAddTodo(@RequestParam int id)
	{
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String goToUpdatetodo(@RequestParam int id, ModelMap model)
	{
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String newupdateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addtodo";
		}
		String username = getLoggedInUser(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUser(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
}
