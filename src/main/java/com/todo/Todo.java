package com.todo;

import java.util.Date;

public class Todo {

    private String title;
    private String note;

    private Date date;

    public Todo(String title, String note, Date date) {
        this.title = title;
        this.note = note;
        this.date = date;
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
}
