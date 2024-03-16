package co.istad.sbdemo.controller;

import co.istad.sbdemo.model.Todo;
import co.istad.sbdemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/todo")
    public String getAllTodoList(Model model){
        List<Todo> todoList = todoService.getAllTodoList();
        model.addAttribute("todos", todoList);
        return "index";
    }
    @GetMapping("/todo/create")
    public String createNew(Model model){
        model.addAttribute("todo", new Todo());
        return "createTodo";
    }
    @PostMapping("/create")
    public String submitCreate(@ModelAttribute("todo") Todo todo){
        todo.setCreateAt(LocalDate.now());
        todoService.addTodoList(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/update/{id}")
    public String updateTodo(@PathVariable("id") Long id, Model model){
        Todo foundTodo = todoService.findById(id);
        model.addAttribute("todo", foundTodo);
        return "update";
    }

    @PostMapping("/todo/update")
    public String submitUpdate(@ModelAttribute("todo") Todo todo){
        todoService.updateTodo(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodoList(id.longValue());
        return "redirect:/todo";
    }

    @GetMapping("/todo/search")
    public String searchTodoList(@RequestParam(required = false) String task,
                                 @RequestParam(required = false) String isDone,
                                 Model model) {
        Boolean isDoneTodo = null;
        if (isDone != null && !isDone.isEmpty()) {
            isDoneTodo = Boolean.parseBoolean(isDone);
        }
        List<Todo> searchTodo = todoService.searchTodos(task, isDoneTodo);
        model.addAttribute("todos", searchTodo);
        return "index";
    }
}
