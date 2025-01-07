package com.todo.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryMem {

    List<User> usersList = new ArrayList<>();

    public UserRepositoryMem() {
        usersList.add(new User("Admin", "Marko", "12345","admin@todo.com", "admin",1));
        usersList.add(new User("Karlo", "Mali", "12345","user@todo.com", "user",0));
    }

    public List<User> getUserList() {
        return usersList;
    }

    public User findById (int id) {
        User user = null;
        for (User u:usersList) {
            if (u.getId()==id) {
                user = u;
            }
        }
        return user;
    }

    public List showOnlyEmployees(){
        List<User> employeesOnlyList = new ArrayList<>();
        for (User u : usersList) {
            if (u.getType() == 0) {
                employeesOnlyList.add(u);
            }
        }
        return employeesOnlyList;
    }

    public void printAllUsers() {
        for (User u : usersList) {
            System.out.println("Id:" + u.getId() + "- Name:" + u.getFirstName());
        }
    }
}
