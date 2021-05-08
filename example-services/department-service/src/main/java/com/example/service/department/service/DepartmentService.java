package com.example.service.department.service;

import com.example.service.department.dto.mapper.DepartmentMapper;
import com.example.service.department.dto.request.DepartmentInsertRequest;
import com.example.service.department.entity.Department;
import com.example.service.department.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DepartmentService {

  private DepartmentRepository departmentRepository;
  private DepartmentMapper departmentMapper;

  public Department saveDepartment(DepartmentInsertRequest departmentInsertRequest) {
    log.info("Inside saveDepartment method of DepartmentService");
    var departmentToSave = departmentMapper.toModel(departmentInsertRequest);
    return departmentRepository.save(departmentToSave);
  }

  public Department findDepartmentById(Long departmentId) {
    log.info("Inside findDepartmentById method of DepartmentService");
    return departmentRepository.findByDepartmentId(departmentId);
  }

}
