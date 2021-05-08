package com.example.service.user.repository;

import com.example.service.user.entitiy.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUserId(Long userId);

}
