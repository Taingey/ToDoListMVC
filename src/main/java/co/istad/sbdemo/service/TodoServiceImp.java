package co.istad.sbdemo.service;

import co.istad.sbdemo.TodoRepository.TodoRepository;
import co.istad.sbdemo.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {
    private final TodoRepository todoRepository;
    @Override
    public List<Todo> getAllTodoList() {
        return todoRepository.getAllTodo();
    }
    @Override
    public Todo addTodoList(Todo todo) {
        return todoRepository.createNewTodo(todo);
    }
    @Override
    public void deleteTodoList(Long id) {
        todoRepository.deleteTodo(id);
    }
    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id);
    }
    @Override
    public void updateTodo(Todo todo) {
        todoRepository.updateTodo(todo);
    }
    @Override
    public List<Todo> searchTodos(String task, Boolean isDone) {
        if (task == null || task.isEmpty()) {
            return getAllTodoList();
        } else {
            return getAllTodoList().stream()
                    .filter(todo -> todo.getTask().contains(task))
                    .collect(Collectors.toList());
        }
    }
}