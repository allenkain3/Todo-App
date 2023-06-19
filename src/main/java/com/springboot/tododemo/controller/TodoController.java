package com.springboot.tododemo.controller;

import com.springboot.tododemo.entity.Todo;
import com.springboot.tododemo.service.TodoService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;


    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    /*List<Todo> todoList;

    //Loading in-Memory Data to test
    @PostConstruct
    public void loadData(){
        Todo todo1 = new Todo(1,"Run 3 miles","5/11/2023");
        Todo todo2 = new Todo(2,"Groceries","6/2/2023");
        Todo todo3 = new Todo(3,"Code for 3 hours","6/2/2023");

        todoList = new ArrayList<>();

        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);
    }*/


    @GetMapping("/list")
    public String listTodos(Model theModel){

        List<Todo> todoList = todoService.findAll();

        theModel.addAttribute("todos",todoList);

        return "list-todos";
    }

    @GetMapping("/showFormToAdd")
    public String showFormToAdd(Model theModel){

        Todo theTodo = new Todo();

        theModel.addAttribute("todo",theTodo);

        return "task-form";
    }


    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todo") Todo theTodo){

        //save task
        todoService.save(theTodo);

        //redirect to main page
        return "redirect:/todos/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int todoId, Model theModel){

        //retrieve the task using the service
        Todo tempTodo = todoService.findById(todoId);

        //set the task in the model to prepopulate the form
        theModel.addAttribute("todo",tempTodo);

        //send over to the task form
        return "task-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("todoId") int theId){

        //delete the task
        todoService.deleteById(theId);

        //redirect to main page
        return "redirect:/todos/list";
    }


}
