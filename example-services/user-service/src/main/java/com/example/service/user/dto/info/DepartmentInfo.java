package com.example.service.user.dto.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfo {

  private Long departmentId;
  private String departmentName;
  private String departmentAddress;
  private String departmentCode;

}
