package com.example.todo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TodoList {
    /* Fields */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
        mappedBy = "todoList",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonManagedReference
    private List <TodoItem> items = new ArrayList<>();

    /* Constructor */
    public TodoList() {}

    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }

    public void addItem(TodoItem item) {
        items.add(item);
        item.setTodoList(this);
    }

    public void removeItem(TodoItem item) {
        items.remove(item);
        item.setTodoList(null);
    }
}