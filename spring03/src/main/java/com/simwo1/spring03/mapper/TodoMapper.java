package com.simwo1.spring03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simwo1.spring03.domain.Todo;

@Mapper
public interface TodoMapper {

    List<Todo> selectTodos();

    Todo selectTodo(int tno);
}