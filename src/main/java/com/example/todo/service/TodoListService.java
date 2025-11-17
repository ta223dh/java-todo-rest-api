package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.todo.dto.TodoListDto;

@Service
public class TodoListService {

  public List<TodoListDto> getAllLists() {

    return List.of();
  }
}
