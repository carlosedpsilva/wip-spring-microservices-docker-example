package com.example.service.user.controller;

import com.example.service.user.dto.request.UserInsertRequest;
import com.example.service.user.dto.response.UserWithDepartmentResponse;
import com.example.service.user.entitiy.User;
import com.example.service.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {

  private UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User saveUser(@RequestBody UserInsertRequest user) {
    log.info("Inside saveUser of UserController");
    return userService.saveUser(user);
  }

  @RequestMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserWithDepartmentResponse getUserWithDepartment(@PathVariable Long userId) {
    log.info("Inside getUserWithDepartment of UserController");
    return userService.getUserWithDepartment(userId);
  }

}
