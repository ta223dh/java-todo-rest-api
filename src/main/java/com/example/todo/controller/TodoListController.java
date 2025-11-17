package com.example.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.todo.service.TodoListService;
import com.example.todo.dto.TodoListDto;

@RestController
public class TodoListController {

  private final TodoListService todoListService;

  public TodoListController(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  @RequestMapping("api/lists")
  public List<TodoListDto> getAllLists() {
    return todoListService.getAllLists();
  }
}
