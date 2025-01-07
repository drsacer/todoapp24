package com.todo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    // ovu metodu koristimo za pronalazak entiteta kad ne želimo koristiti Optional<User> u Controlleru. Tada moramo sami napraviti metodu
   // User findById(int id);
    List<User> findByType(int type);

}