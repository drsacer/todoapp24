package com.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity (name="APP_USER")
public class User {
    private String firstName;
    private String lastName;
    private String oib;
    private String email;
    private String password;
    @Id
    @GeneratedValue
    private int id;
    private int type = 0;  // 0 - employee , 1 - supervizor
   // private List<Todo> todos = new ArrayList<>();

    public User(String firstName, String lastName, String oib, String email, String password, int type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public String getOib() {
        return oib;
    }

    //  public List<Todo> getTodos() {return todos;}


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", oib='" + oib + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + id +
                ", type=" + type +
                '}';
    }
}
