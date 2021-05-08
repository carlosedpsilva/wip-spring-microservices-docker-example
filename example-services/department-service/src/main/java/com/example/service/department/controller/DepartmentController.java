package com.example.service.department.controller;

import com.example.service.department.dto.request.DepartmentInsertRequest;
import com.example.service.department.entity.Department;
import com.example.service.department.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DepartmentController {

  private DepartmentService departmentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Department saveDepartment(@RequestBody DepartmentInsertRequest department) {
    log.info("Inside saveDepartment method of DepartmentController");
    return departmentService.saveDepartment(department);
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Department findDepartmentById(@PathVariable("id") Long departmentId) {
    log.info("Inside findDepartmentById method of DepartmentController");
    return departmentService.findDepartmentById(departmentId);
  }

}
