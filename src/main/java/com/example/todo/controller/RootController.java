package com.example.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.todo.common.Messages.WELCOME_MESSAGE;

@RestController
public class RootController {

  @GetMapping("/api")
  public String welcome() {
    return WELCOME_MESSAGE;
  }
}
