package com.todo.controller;

import com.todo.model.User;
import com.todo.model.UserRepositoryMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepositoryMem userRepo;


    @GetMapping("/employees")
    public String employees(Model model) {
        model.addAttribute(userRepo.showOnlyEmployees());
        //model.addAttribute(user);
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
        userRepo.getUserList().add(newUser);

        return "redirect:/employees";
    }

    @GetMapping("/showEditEmployee")
    public String showEditTodo(@RequestParam("employeeId") int id, Model model){
        User employeeToEdit = userRepo.findById(id);
        model.addAttribute("employee", employeeToEdit);
        return "supervisor_edit_employee.html";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam("id") int employeeId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                           @RequestParam("oib") String oib, @RequestParam("email") String email, @RequestParam("password") String password,
                           Model model ){

        User userToEdit = userRepo.findById(employeeId);
        userToEdit.setFirstName(firstName);
        userToEdit.setLastName(lastName);
        userToEdit.setOib(oib);
        userToEdit.setEmail(email);
        userToEdit.setPassword(password);

        return "redirect:/employees";
    }

    @GetMapping("/showTodosForEmployee")
    public String showTodos(@RequestParam("employeeId") int id, Model model){
        User userToShowTodos = userRepo.findById(id);
        model.addAttribute(userToShowTodos.getTodos());

        return "employee_todos.html";
    }


    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        User userToDelete = userRepo.findById(id);
       // System.out.println("Deleted id " + userToDelete.getId());
        userRepo.getUserList().remove(userToDelete);
        userRepo.setListIdAfterDeletingEmployee(id);
        User.idEmployeeCounter = userRepo.getUserList().size()+1;

       // userRepo.setListIdAfterDeletingTodo(id);
        //nakon što se izbrišu neki todo-ovi u listi potrebno je counter staviti na zadnji broj (veličina liste) + 1
        //Todo.idCounter = todoRepo.getTodoList().size()+1;
        return "redirect:/employees";
    }
}
