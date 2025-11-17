package com.example.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  @GetMapping("/api")
  public String welcome() {
    return "Welcome to the Todo REST API";
  }
}
