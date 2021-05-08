package com.example.service.user.dto.mapper;

import com.example.service.user.dto.request.UserInsertRequest;
import com.example.service.user.entitiy.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toModel(UserInsertRequest userInsertRequest);

}
