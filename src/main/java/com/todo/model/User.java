package com.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Entity (name="APP_USER")
@Data

public class User implements Serializable  {
    private String firstName;
    private String lastName;
    private String oib;
    private String email;
    private String password;
    private String address;

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




}
