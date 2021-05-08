package com.example.service.department.dto.mapper;

import com.example.service.department.dto.request.DepartmentInsertRequest;
import com.example.service.department.entity.Department;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

  Department toModel(DepartmentInsertRequest insertRequest);

}
