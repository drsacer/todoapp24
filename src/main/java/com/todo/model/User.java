package com.todo.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String oib;
    private String email;
    private String password;
    private int employeeId;
    public static int idEmployeeCounter = 1;
    private int type = 0;  // 0 - employee , 1 - supervizor

    private List<Todo> todos = new ArrayList<>();

    public User(String firstName, String lastName, String oib, String email, String password, int type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.email = email;
        this.password = password;
        this.type = type;

        employeeId = idEmployeeCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static int getIdEmployeeCounter() {
        return idEmployeeCounter;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        this.todos.add(todo);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", oib='" + oib + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                ", type=" + type +
                '}';
    }
}
