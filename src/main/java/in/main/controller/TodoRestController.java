package in.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.entity.Todo;
import in.main.service.TodoService;

@RestController
@RequestMapping("/todoApp")
public class TodoRestController {

	@Autowired
	private TodoService todoService;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Todo todo){
		
		return new ResponseEntity<>(todoService.saveTodo(todo),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		
		return new ResponseEntity<>(todoService.getAllTodos(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getBy/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		
		return new ResponseEntity<>(todoService.getById(id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		todoService.delete(id);
		return new ResponseEntity<>("todo delete successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBy/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Todo todo){
		
		return new ResponseEntity<>(todoService.update(id,todo),HttpStatus.CREATED);
	}
	
	
}
