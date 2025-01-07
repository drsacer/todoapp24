package com.todo.controller;

import com.todo.model.Todo;
import com.todo.model.TodoRepository;
import com.todo.model.User;
import com.todo.model.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepoDB;
    @Autowired
    UserRepository userRepoDB;

    @GetMapping("/todos")
    public String showTodos(Model model, HttpSession session) {

        User currentUser = (User) session.getAttribute("user");
        userRepoDB.findById(currentUser.getId());
        List<Todo> todos = todoRepoDB.findByUser(currentUser);

        model.addAttribute("todos", todos);

        return "employee_todos.html";
    }

    @GetMapping("/openAddNewTodo")
    public String openAddTodo(){
        return "employee_add_todo.html";
    }

    @GetMapping("/addNewTodo")
    public String addNewTodo(@RequestParam("date") String dateString, @RequestParam("title") String title, @RequestParam("note") String note,
                             Model model, HttpSession session ){

        User currentUser = (User) session.getAttribute("user");

        LocalDate date = LocalDate.parse(dateString);
        Todo newTodo = new Todo(title, note, date);
        newTodo.setUser(currentUser);
       // session.getAttribute("user");
        todoRepoDB.save(newTodo);

        return "redirect:/todos";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") int id) {

        Todo todoToDelete = todoRepoDB.findById(id).get();
        todoRepoDB.delete(todoToDelete);

        return "redirect:/todos";
    }

    @GetMapping("/showEditTodo")
    public String showEditTodo(@RequestParam("id") int id, Model model){
        Todo todoToEdit = todoRepoDB.findById(id).get();
        model.addAttribute("todo", todoToEdit);
        return "employee_edit_todo.html";
    }

    @GetMapping("/editTodo")
    public String editTodo(@RequestParam("date") String dateString, @RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("note") String note, Model model){

        LocalDate date = LocalDate.parse(dateString);

        Todo todoToEdit = todoRepoDB.findById(id).get();
        todoToEdit.setTitle(title);
        todoToEdit.setNote(note);
        todoToEdit.setDate(date);

        todoRepoDB.save(todoToEdit);

        return "redirect:/todos";
    }
}
