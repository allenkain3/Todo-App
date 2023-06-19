package com.springboot.tododemo.service;

import com.springboot.tododemo.dao.TodoRepository;
import com.springboot.tododemo.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository theTodoRepository){
        this.todoRepository = theTodoRepository;
    }
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByStartDateAsc();
    }

    @Override
    public Todo findById(int todoId) {

        Optional<Todo> result = todoRepository.findById(todoId);

        Todo theTodo = null;

        if (result.isPresent()) {
            theTodo = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find todo id - " + theTodo);
        }

        return theTodo;

    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteById(int todoId) {
        todoRepository.deleteById(todoId);
    }
}
