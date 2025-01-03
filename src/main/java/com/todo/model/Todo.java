package com.todo.model;

import java.time.LocalDate;

public class Todo {

    private String title;
    private String note;
    private int id;
    private static int idCounter;


    private LocalDate date;

    public Todo(String title, String note, LocalDate date) {
        this.title = title;
        this.note = note;
        this.date = date;

        id = idCounter++;
    }

    public Todo(String title, String note) {
        this.title = title;
        this.note = note;
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
