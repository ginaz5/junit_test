package com.course.mockito.data.api;

import java.util.List;

// External Service - Lets say this comes from WunderList
// TodoService can be talking to a DB or external interface
public interface TodoService {
    public List<String> retrieveTodos(String user);

    public void deleteTodo(String todo);
}