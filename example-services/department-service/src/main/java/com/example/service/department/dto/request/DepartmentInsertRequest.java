package com.example.service.department.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInsertRequest {

  private String departmentName;
  private String departmentAddress;
  private String departmentCode;

}
