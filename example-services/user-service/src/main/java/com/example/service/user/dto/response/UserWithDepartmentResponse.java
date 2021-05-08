package com.example.service.user.dto.response;

import com.example.service.user.dto.info.DepartmentInfo;
import com.example.service.user.entitiy.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartmentResponse {

  private User user;
  private DepartmentInfo department;

}
