package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TodoController {

    TodoRepositoryMem todoRepo;
    public TodoController(TodoRepositoryMem todoRepo) {
        this.todoRepo = todoRepo;
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
        model.addAttribute(todoRepo.getTodoList());
        return "employee_todos.html";
    }

    @GetMapping("/addNewTodo")
    public String addNewTodo(@RequestParam("title") String title, @RequestParam("note") String note ){
        Todo newTodo = new Todo(title, note, new Date());
        todoRepo.getTodoList().add(newTodo);

        return "redirect:/todos";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") int id) {
        for (Todo t:todoRepo.getTodoList()) {
            if(t.getId()==id) {
                todoRepo.getTodoList().remove(t);
                break;
            }
        }
        return "redirect:/todos";
    }

    @GetMapping("/showTodo")
    public String showTodo(@RequestParam ("id") int id, Model model) {
        Todo todoToEdit = todoRepo.findById(id);
       model.addAttribute("todo", todoToEdit);

       return "employee_edit_todo.html";
    }

    @GetMapping("/editTodo")
    public String editTodo(@RequestParam ("id") int id,
                           @RequestParam ("title") String title,
                           @RequestParam ("note") String note) {

        Todo todoToEdit = todoRepo.findById(id);
        todoToEdit.setTitle(title);
        todoToEdit.setNote(note);

        return "redirect:/todos";
    }

    @GetMapping("/loginProcess")
    public String loginProcess( @RequestParam ("email") String email,
                                @RequestParam ("password") String password,
                                Model model) {

        if (email.equals("admin@todo.com")) {
            model.addAttribute("email", email);
            return "supervisor_employees.html";
        } else if (email.equals("user@todo.com")) {
            return "redirect:/todos";
        } else {
            model.addAttribute("loginMessage", "Wrong username or password");
            return "login.html";
        }
    }
}
