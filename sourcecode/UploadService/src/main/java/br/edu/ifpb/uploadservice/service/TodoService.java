package br.edu.ifpb.uploadservice.service;

import br.edu.ifpb.uploadservice.domain.Arquivo;
import br.edu.ifpb.uploadservice.domain.Todo;
import br.edu.ifpb.uploadservice.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> listarTodos() {
        return todoRepository.findAll();
    }

    public Todo salvarTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> buscarPorId(Integer id) {
        return todoRepository.findById(id);
    }

    public long totalTodos() {
        return todoRepository.count();
    }


    public void apagarTodo(Todo todo) {
        todoRepository.delete(todo);
    }
}
