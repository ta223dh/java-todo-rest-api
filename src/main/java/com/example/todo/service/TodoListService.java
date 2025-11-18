package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.todo.dto.TodoListDto;

import com.example.todo.repository.TodoListRepository;

@Service
public class TodoListService {

  private final TodoListRepository todoListRepository;

  public TodoListService(TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
  }

  public List<TodoListDto> getAllLists() {

    return this.todoListRepository.findAll()
        .stream()
        .map(entity -> new TodoListDto(entity.getId(), entity.getName()))
        .toList();
  }
}
