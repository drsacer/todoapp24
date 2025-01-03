package com.todo.controller;

import com.todo.model.Todo;
import com.todo.model.TodoRepositoryMem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TodoController {

    @Autowired
    TodoRepositoryMem todoRepo;

    @GetMapping("/todos")
    public String showTodos(Model model, HttpSession session) {
        //User user = (User) session.getAttribute("user");
        session.getAttribute("user");

        model.addAttribute(todoRepo.getTodoList());
        //model.addAttribute("user", user);

        return "employee_todos.html";
    }

    @GetMapping("/openAddNewTodo")
    public String openAddTodo(){
        return "employee_add_todo.html";
    }

    @GetMapping("/addNewTodo")
    public String addNewTodo(@RequestParam("date") String dateString, @RequestParam("title") String title, @RequestParam("note") String note,
                             Model model, HttpSession session ){
        LocalDate date = LocalDate.parse(dateString);
        Todo newTodo = new Todo(title, note, date);
        session.getAttribute("user");
        todoRepo.getTodoList().add(newTodo);

        return "redirect:/todos";
    }
    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") int id) {

        Todo todoToDelete = todoRepo.findById(id);
        todoRepo.getTodoList().remove(todoToDelete);
        System.out.println(todoRepo.getTodoList());

        return "redirect:/todos";
    }

    @GetMapping("/showEditTodo")
    public String showEditTodo(@RequestParam("id") int id, Model model){
        Todo todoToEdit = todoRepo.findById(id);
        model.addAttribute("todo", todoToEdit);
        return "employee_edit_todo.html";
    }

    @GetMapping("/editTodo")
    public String editTodo(@RequestParam("date") String dateString, @RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("note") String note, Model model){

        LocalDate date = LocalDate.parse(dateString);

        Todo todoToEdit = todoRepo.findById(id);
        todoToEdit.setTitle(title);
        todoToEdit.setNote(note);
        todoToEdit.setDate(date);

        return "redirect:/todos";
    }
}
