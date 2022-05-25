package com.course.mockito.data.api;

import java.util.Arrays;
import java.util.List;

// Create dummy implementation for tests
public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
    }
}
