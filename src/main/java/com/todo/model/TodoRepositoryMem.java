package com.todo.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TodoRepositoryMem {

    List<Todo> todoList = new ArrayList<>();

    public TodoRepositoryMem() {

        todoList.add(new Todo("Spring", "Easy",new Date()));
        todoList.add(new Todo("JS", "Medium", new Date()));
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public Todo findById (int id) {
        Todo todo = null;
        for (Todo t:todoList) {
            if (t.getId()==id) {
                todo = t;
            }
        }
        return todo;
    }



/*    public boolean printListTodos(){
        for (Todo t:todoList) {
            System.out.println("RB:" + t.getId() + "-" + t.getTitle());
        }
        return false;
    }*/

    @Override
    public String toString() {
        return "TodoRepositoryMem{" +
                "todoList=" + todoList +
                '}';
    }
}
