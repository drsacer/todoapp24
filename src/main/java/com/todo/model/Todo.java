package com.todo.model;

import java.time.LocalDate;
import java.util.Date;

public class Todo {

    private String title;
    private String note;

    private int id;
    public static int idCounter=1;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", id=" + id +
                '}';
    }
}
