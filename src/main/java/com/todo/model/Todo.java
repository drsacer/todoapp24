package com.todo.model;

import java.util.Date;

public class Todo {

    private String title;
    private String note;

    private Date date;

    public Todo(String title, String note) {
        this.title = title;
        this.note = note;
<<<<<<<< HEAD:src/main/java/com/todo/model/Todo.java

        id = idCounter++;
========
        this.date = date;
>>>>>>>> origin/master:src/main/java/com/todo/Todo.java
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

<<<<<<<< HEAD:src/main/java/com/todo/model/Todo.java

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

========
    public Date getDate() {
        return date;
    }
>>>>>>>> origin/master:src/main/java/com/todo/Todo.java
}
