package br.edu.ifpb.todo;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.repository.TodoRepository;
import br.edu.ifpb.todo.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	private TodoService todoService;

	@Test
	public void deveCriarTodo() {
		Todo todo = new Todo();
		todo.setTitulo("Nova todo");
		todoService.salvarTodo(todo);
		assertTrue(todo.getId() != null);
	}

	@Test
	public void deveListarTodo() {
		long todosAntesDeCriar = todoService.totalTodos();
		Todo todo = new Todo();
		todo.setTitulo("Mais uma todo criada");
		todoService.salvarTodo(todo);
		long todosDepoisDeCriar = todoService.totalTodos();
		assertTrue(todosDepoisDeCriar == todosAntesDeCriar+1);
	}

	@Test
	public void deveRemoverTodo() {
		Todo todo = new Todo();
		todo.setTitulo("Todo a ser apagada");
		todoService.salvarTodo(todo);
		long todosAntesDeApagar = todoService.totalTodos();
		todoService.apagarTodo(todo);
		long todosDepoisDeApagar = todoService.totalTodos();
		assertTrue(todosDepoisDeApagar == todosAntesDeApagar-1);
	}

}
