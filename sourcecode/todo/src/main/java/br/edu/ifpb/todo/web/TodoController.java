package br.edu.ifpb.todo.web;


import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.service.TodoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().body(todoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Todo> postTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.salvarTodo(todo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTodo(@RequestParam("id") Integer id) {
        Optional<Todo> todo = todoService.buscarPorId(id);
        if (todo.isPresent()) {
            todoService.apagarTodo(todo.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Todo de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
