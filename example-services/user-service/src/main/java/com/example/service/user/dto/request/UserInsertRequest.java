package com.example.service.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertRequest {

  private String firstName;
  private String lastName;
  private String email;
  private Long departmentId;

}
