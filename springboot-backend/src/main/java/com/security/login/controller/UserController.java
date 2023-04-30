package com.security.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.login.models.User;
import com.security.login.repo.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
  
@Autowired
  private UserRepo repo;

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody User userData){


    System.out.println(userData);

    

    User user=repo.findByUserId(userData.getUserId());

     if(user.getPassword().equals(userData.getPassword()))
     return ResponseEntity.ok(user);

    return (ResponseEntity<?>) ResponseEntity.internalServerError();

  } 

  @PostMapping("/register")
public ResponseEntity<?> registerUser(@RequestBody User userData) {
    User user = repo.findByUserId(userData.getUserId());
    if (user != null && user.getUserId().equals(userData.getUserId())) {
        
        return ResponseEntity.internalServerError().build();
    } else {
        
        return ResponseEntity.ok(repo.save(userData));
    }
}
}
 