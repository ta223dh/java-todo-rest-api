package com.example.todo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.todo.dto.TodoListRequest;
import com.example.todo.dto.TodoListResponse;
import com.example.todo.service.TodoListService;

import java.util.List;

@WebMvcTest(TodoListController.class)
public class TodoListControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockitoBean 
  private TodoListService todoListService;

  @Test
  void shouldReturnEmptyArray_whenNoTodoListsExist() throws Exception {
    when(todoListService.getAllLists()).thenReturn(List.of());

    mockMvc.perform(get("/api/lists"))
      .andExpect(status().isOk())
      .andExpect(content().json("[]"));
  }

  @Test
  void shouldReturnTodoLists_whenTodoListsExist() throws Exception {

    when(todoListService.getAllLists()).thenReturn(List.of(
        new TodoListResponse(1, "My first todo list"),
        new TodoListResponse(2, "My second todo list")  
    ));

    mockMvc.perform(get("/api/lists"))
   .andExpect(status().isOk())
    .andExpect(jsonPath("$[0].id").value(1))
    .andExpect(jsonPath("$[0].name").value("My first todo list"))
    .andExpect(jsonPath("$[1].id").value(2))
    .andExpect(jsonPath("$[1].name").value("My second todo list"));
  }

  @Test
  void shouldReturnCreatedTDO_whenPostingNewTodoList() throws Exception {
    final String TODO_LIST_NAME = "My new todo list";
    var requestBody = """
      {
        "name": "%s"
      }
      """.formatted(TODO_LIST_NAME);

    when(todoListService.createList(new TodoListRequest(TODO_LIST_NAME)))
      .thenReturn(new TodoListResponse(1, TODO_LIST_NAME));

    mockMvc.perform(
        post("/api/lists")
          .contentType("application/json")
          .content(requestBody)
      )
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.name").value(TODO_LIST_NAME));
  }

  @Test
  void shouldReturnBadRequest_whenPostingNewTodoListWithEmptyName() throws Exception {
    var requestBody = """
      {
        "name": ""
      }
      """;

    mockMvc.perform(
          post("/api/lists")
          .contentType("application/json")
          .content(requestBody)
      )
      .andExpect(status().isBadRequest());
  }
}