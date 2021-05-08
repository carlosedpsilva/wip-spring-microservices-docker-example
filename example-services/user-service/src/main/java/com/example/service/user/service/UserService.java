package com.example.service.user.service;

import com.example.service.user.dto.info.DepartmentInfo;
import com.example.service.user.dto.mapper.UserMapper;
import com.example.service.user.dto.request.UserInsertRequest;
import com.example.service.user.dto.response.UserWithDepartmentResponse;
import com.example.service.user.entitiy.User;
import com.example.service.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserService {

  private UserRepository userRepository;
  private RestTemplate restTemplate;
  private UserMapper userMapper;

  public User saveUser(UserInsertRequest userInsertRequest) {
    log.info("Inside saveUser of UserService");
    var userToSave = userMapper.toModel(userInsertRequest);
    return userRepository.save(userToSave);
  }

  public UserWithDepartmentResponse getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment of UserService");
    UserWithDepartmentResponse response = new UserWithDepartmentResponse();
    User user = userRepository.findByUserId(userId);
    DepartmentInfo department = restTemplate.getForObject(
      "http://DEPARTMENT-SERVICE/api/v1/departments/" + userId,
      DepartmentInfo.class
    );
    response.setUser(user);
    response.setDepartment(department);
    return response;
  }

}
