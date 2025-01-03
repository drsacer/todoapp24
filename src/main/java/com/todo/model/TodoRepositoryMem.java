package com.todo.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryMem {
    List<Todo> todoList = new ArrayList<>();

    public TodoRepositoryMem() {
        todoList.add(new Todo("BS", "Easy"));
        todoList.add(new Todo("JS", "Medium"));
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
