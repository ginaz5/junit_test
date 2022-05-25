package com.course.mockito.data.business;

import com.course.mockito.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

// TodoBusinessImpl is System Under Test, contains business logic that we want to test
// TodoService dependency
public class TodoBusinessImpl {

    private TodoService todoService;

    // Constructor enables us to test TodoBusinessImpl
    // with any implementation of TodoService
    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    // this method we want to write tests for in the future
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo: allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
