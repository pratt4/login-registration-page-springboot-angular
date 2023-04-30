package com.security.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.login.models.User;


@Repository
public interface UserRepo extends JpaRepository<User,String>{

  User findByUserId(String userId);
  
}
