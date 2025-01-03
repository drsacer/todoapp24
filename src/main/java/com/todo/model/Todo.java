package com.todo.model;

import java.util.Date;

public class Todo {

    private String title;
    private String note;
    private int id;
    private static int idCounter;


    private Date date;

    public Todo(String title, String note) {
        this.title = title;
        this.note = note;

        id = idCounter++;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
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

}