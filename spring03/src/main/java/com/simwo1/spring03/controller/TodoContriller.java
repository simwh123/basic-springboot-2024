package com.simwo1.spring03.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.simwo1.spring03.domain.Todo;
import com.simwo1.spring03.service.TodoService;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoContriller {
    @Resource
    TodoService todoService;

    @GetMapping("/todos")
    public String getTodos(Model model) throws Exception {
        List<Todo> allTodos = todoService.getTodoAll();
        model.addAttribute("todoList", allTodos);
        return "todolist";
    }

    @GetMapping("/todo/{ino}")
    @ResponseBody
    public Todo getTodo(@PathVariable(name = "ino") int ino) throws Exception {
        return todoService.getTodoByTno(ino);
    }

}
