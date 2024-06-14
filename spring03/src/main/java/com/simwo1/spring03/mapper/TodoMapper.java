package com.simwo1.spring03.mapper;

import java.util.List;

import com.simwo1.spring03.domain.Todo;

public interface TodoMapper {

    List<Todo> selectTodos();

    Todo selectTodo(int ino);
}