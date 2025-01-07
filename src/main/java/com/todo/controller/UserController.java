package com.todo.controller;

import com.todo.model.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepositoryMem userRepo;

    @Autowired
    UserRepository userRepositoryDB;
    @Autowired
    TodoRepository todoRepositoryDB;

    @GetMapping("/employees")
    public String employees(Model model , HttpSession session) {
        session.getAttribute("user");
        model.addAttribute(userRepositoryDB.findByType(0));

        return "supervisor_employees.html";
    }


    @GetMapping("/openSupervisorAddEmployee")
    public String openAddTodo(){
        return "supervisor_add_employee.html";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                 @RequestParam("oib") String oib, @RequestParam("email") String email, @RequestParam("password") String password,
                                 Model model ){
        User newUser = new User(firstName, lastName, oib, email, password,0);
        userRepositoryDB.save(newUser);

        return "redirect:/employees";
    }

    @GetMapping("/showEditEmployee")
    public String showEditEmployee(@RequestParam("id") int id, Model model){

        User employeeToEdit = userRepositoryDB.findById(id).get();
        model.addAttribute("employee", employeeToEdit);
        return "supervisor_edit_employee.html";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                           @RequestParam("oib") String oib, @RequestParam("email") String email, @RequestParam("password") String password,
                           Model model ){

        User userToEdit = userRepositoryDB.findById(id).get();
        userToEdit.setFirstName(firstName);
        userToEdit.setLastName(lastName);
        userToEdit.setOib(oib);
        userToEdit.setEmail(email);
        userToEdit.setPassword(password);

        userRepositoryDB.save(userToEdit);

        return "redirect:/employees";
    }

    @GetMapping("/showTodosForEmployee")
    public String showTodos(@RequestParam("id") int id, Model model){
        User currentUser = userRepositoryDB.findById(id).get();
        List<Todo> todos = todoRepositoryDB.findByUser(currentUser);
        model.addAttribute("todos",todos);
        model.addAttribute("employee",currentUser);

        return "supervisor_employee_todos.html";
    }


    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        //  Optional<T> koristimo kako bismo upravljali mogućim null vrijednostima koje mogu nastati prilikom pretrage objekta u bazi podataka
        //  Da bi mogli koristiti findById metodu iz JpaRepository-a automastki se casta u Optional

       /* Optional<User> userToDelete = userRepositoryDB.findById(id);
        userToDelete.ifPresent(userRepositoryDB::delete);*/

        User employeeToDelete = userRepositoryDB.findById(id).get();
        userRepositoryDB.delete(employeeToDelete);

        return "redirect:/employees";
    }
}
