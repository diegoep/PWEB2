package br.edu.ifpb.todo.repository;

import br.edu.ifpb.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
