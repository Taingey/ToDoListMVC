// TodoService.java
package co.istad.sbdemo.service;

import co.istad.sbdemo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    List<Todo> getAllTodoList();
    Todo addTodoList(Todo todo);
    void deleteTodoList(Long id);
    Todo findById(Long id);
    void updateTodo(Todo todo);
    List<Todo> searchTodos(String task, Boolean isDone);
}