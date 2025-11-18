package com.example.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;

import java.util.List;
import com.example.todo.service.TodoListService;
import com.example.todo.dto.TodoListRequest;
import com.example.todo.dto.TodoListResponse;

@RestController
public class TodoListController {

  private final TodoListService todoListService;

  public TodoListController(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  @GetMapping("api/lists")
  public List<TodoListResponse> getAllLists() {
    return todoListService.getAllLists();
  }

  @PostMapping("api/lists")
  @ResponseStatus(HttpStatus.CREATED)
  public TodoListResponse createList(@RequestBody @Valid TodoListRequest dto) {
    return todoListService.createList(dto);
  }
}
