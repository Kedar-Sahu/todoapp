package in.main.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entity.Todo;
import in.main.exception.ResourceNotFoundException;
import in.main.repository.TodoRepository;
import in.main.service.TodoService;

@Service
public class TodoServiceImp implements TodoService{

	
	@Autowired
	private TodoRepository todoRepository;
	
	
	@Override
	public Todo saveTodo(Todo todo) {

		return todoRepository.save(todo);
	}

	@Override
	public List<Todo> getAllTodos() {
		
		return todoRepository.findAll();
	}

	@Override
	public Todo getById(int id) {
		
		return todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("todo id not found with id ="+id ));
	}

	@Override
	public void delete(int id) {
		Todo todo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("todo id not found with id ="+id ));
		todoRepository.delete(todo);
	}

	@Override
	public Todo update(int id,Todo todo) {
		Todo saveTodo=todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("todo id not found with id ="+id ));
		saveTodo.setTitle(todo.getTitle());
		saveTodo.setDescription(todo.getDescription());
		saveTodo.setStatus(todo.getStatus());
		saveTodo.setUsername(todo.getUsername());
		
		return todoRepository.save(saveTodo);
	}

}
