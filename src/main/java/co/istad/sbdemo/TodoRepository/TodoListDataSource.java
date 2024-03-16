package co.istad.sbdemo.TodoRepository;


import co.istad.sbdemo.model.Todo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import co.istad.sbdemo.TodoRepository.TodoRepository;

@Repository
public class TodoListDataSource implements TodoRepository {
    private List<Todo> todos = new ArrayList<>();
    private Long nextTodoId = 1L;

    @Override
    public List<Todo> getAllTodo() {
        return todos;
    }

    @Override
    public Todo createNewTodo(Todo todo) {
        todo.setId(nextTodoId++);
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo findById(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public void deleteTodo(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public void updateTodo(Todo todo) {
        for (Todo t : todos) {
            if (t.getId().equals(todo.getId())) {
                t.setTask(todo.getTask());
                t.setDescription(todo.getDescription());
                t.setIsDone(todo.getIsDone());
                break;
            }
        }
    }
}
