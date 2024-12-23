package com.todo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TodoRepositoryMem {
    List<Todo> todoList = new ArrayList<>();

    public TodoRepositoryMem() {
        todoList.add(new Todo("BS", "Easy", new Date()));
        todoList.add(new Todo("JS", "Medium", new Date()));
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public Todo findById(int id){
        Todo todoToEdit = null;
        for (Todo t: todoList) {
            if(t.getId() == id) {
                todoToEdit = t;
            }
        }
        return todoToEdit;
    }
}
