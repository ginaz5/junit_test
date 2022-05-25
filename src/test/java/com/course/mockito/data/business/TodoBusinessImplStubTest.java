package com.course.mockito.data.business;

import com.course.mockito.data.api.TodoService;
import com.course.mockito.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
// cons of using stub - dynamic conditions, it will hard to maintain

public class TodoBusinessImplStubTest {

    @Test
    public void retrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test // exercise - improve assert, check the content of the stub
    public void retrieveTodosRelatedToSpring_test_content() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        List<String> toCheck = Arrays.asList("Learn Spring MVC", "Learn Spring") ;
        assertEquals(toCheck, filteredTodos);
    }
}