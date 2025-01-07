package com.todo.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Todo {

    private String title;
    private String note;
    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo(String title, String note, LocalDate date) {
        this.title = title;
        this.note = note;
        this.date = date;

    }

    public Todo(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public Todo() {
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
