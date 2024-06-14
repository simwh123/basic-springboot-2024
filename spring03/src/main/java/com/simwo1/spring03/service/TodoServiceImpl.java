package com.simwo1.spring03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simwo1.spring03.domain.Todo;
import com.simwo1.spring03.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    @Override
    public List<Todo> getTodoAll() throws Exception {
        return todoMapper.selectTodos();
    }

    @Override
    public Todo getTodoByTno(int tno) throws Exception {
        return todoMapper.selectTodo(tno);
    }
}
