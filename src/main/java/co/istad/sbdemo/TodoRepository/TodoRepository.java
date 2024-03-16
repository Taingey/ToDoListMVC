package co.istad.sbdemo.TodoRepository;
import co.istad.sbdemo.model.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> getAllTodo();
    Todo createNewTodo(Todo todo);
    void deleteTodo(Long id);
    Todo findById(Long id);
    void updateTodo(Todo todo);
}
