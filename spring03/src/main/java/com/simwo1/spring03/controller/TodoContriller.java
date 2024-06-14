package com.simwo1.spring03.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.simwo1.spring03.domain.Todo;
import com.simwo1.spring03.service.TodoService;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoContriller {
    @Resource
    TodoService todoService;

    @GetMapping("/todos")
    @ResponseBody
    public List getMethodName() throws Exception {
        List<Todo> allTodos = todoService.getTodoAll();
        return allTodos;
    }

}
