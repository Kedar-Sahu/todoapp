package in.main.service;

import java.util.List;

import in.main.entity.Todo;

public interface TodoService {

	Todo saveTodo(Todo todo);
	List<Todo> getAllTodos();
	Todo getById(int id);
	void delete(int id);
	Todo update(int id,Todo todo);
}
