package com.example.todo.todo.service;

import com.example.todo.todo.interfaces.UserRepository;
import com.example.todo.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired

    private UserRepository repo;

    public User login(String username, String password){
      User user = repo.findByUsernameAndPassword(username, password);
      return user;
    }
}
