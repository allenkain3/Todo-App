package com.springboot.tododemo.service;

import com.springboot.tododemo.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo findById(int todoId);

    void save(Todo todo);

    void deleteById(int todoId);
}
