package com.todo.model;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    // ovu metodu koristimo za pronalazak entiteta kad ne želimo koristiti Optional<User> u Controlleru. Tada moramo sami napraviti metodu
   // User findById(int id);
    List<User> findByType(int type);

    //@Query("SELECT u FROM User u WHERE u.type = 0")
    @Query(value =  "SELECT * FROM APP_USER u WHERE u.type = 0", nativeQuery = true)
    List<User> findAllEmployees();



}