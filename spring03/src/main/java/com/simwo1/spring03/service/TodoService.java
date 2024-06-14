package com.simwo1.spring03.service;

import java.util.List;

import com.simwo1.spring03.domain.Todo;

public interface TodoService {

    public List<Todo> getTodoAll() throws Exception;

    public Todo getTodoByTno(int tno) throws Exception;
}
