package br.edu.ifpb.uploadservice.repository;

import br.edu.ifpb.uploadservice.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
