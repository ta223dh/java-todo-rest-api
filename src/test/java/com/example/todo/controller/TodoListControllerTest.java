package com.example.todo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

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
}
