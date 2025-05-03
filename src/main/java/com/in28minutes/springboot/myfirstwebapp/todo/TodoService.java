package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todocount = 0;
	
	static {
		
		todos.add(new Todo(++todocount, "Vineet", "learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todocount, "Vineet", "learn Devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todocount, "Vineet", "learn Springboot", LocalDate.now().plusYears(3), false));
	}


	
	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done)
	{
		Todo todo = new Todo(++todocount, username, description, date, done);
		todos.add(todo);
	}
	
	public void deleteById(int id)
	{
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
}
