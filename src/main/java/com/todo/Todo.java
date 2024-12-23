package com.todo;

import java.util.Date;

public class Todo {

    private String title;
    private String note;
    private int id;
    private static int idCounter;


    private Date date;

    public Todo(String title, String note, Date date) {
        this.title = title;
        this.note = note;
        this.date = date;

        id = idCounter++;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public Date getDate() {
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

    public void setDate(Date date) {
        this.date = date;
    }
}
