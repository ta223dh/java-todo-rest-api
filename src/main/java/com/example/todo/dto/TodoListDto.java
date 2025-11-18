package com.example.todo.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

public record TodoListDto(
  long id,
  @NotBlank(message = "Name field required")
  @Size(max = 1000, message = "Name field cannot be longer than 1000 characters")
  String name
  ) { }