package in.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{

}
