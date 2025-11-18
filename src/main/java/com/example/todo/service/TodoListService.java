package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoListRequest;
import com.example.todo.dto.TodoListResponse;
import com.example.todo.entity.TodoList;
import com.example.todo.repository.TodoListRepository;

@Service
public class TodoListService {

  private final TodoListRepository todoListRepository;

  public TodoListService(TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
  }

  public List<TodoListResponse> getAllLists() {

    return this.todoListRepository.findAll()
        .stream()
        .map(entity -> new TodoListResponse(entity.getId(), entity.getName()))
        .toList();
  }

  public TodoListResponse createList(TodoListRequest dto) {
    var entity = new TodoList(dto.name());
    var savedEntity = todoListRepository.save(entity);
    return new TodoListResponse(savedEntity.getId(), savedEntity.getName());
  }
}
