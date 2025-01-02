package com.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TodoController {
    List<Todo> todoList = new ArrayList<>();

    public TodoController() {
        todoList.add(new Todo("BS", "Easy", new Date()));
        todoList.add(new Todo("JS", "Medium", new Date()));
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    @GetMapping("/")
    public String loginIndex() {
        return "redirect:/login";
    }

    @GetMapping("/todos")
    public String showTodos(Model model) {
        model.addAttribute(todoList);
        return "employee_todos.html";
    }

    @GetMapping("/addNewTodo")
    public String addNewTodo(@RequestParam("title") String title, @RequestParam("note") String note ){
        Todo newTodo = new Todo(title, note, new Date());
        todoList.add(newTodo);

        return "redirect:/todos";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("title") String title) {
        for (Todo t:todoList) {
            if(t.getTitle().equals(title)) {
                todoList.remove(t);
                break;
            }
        }
        return "redirect:/todos";
    }
}
