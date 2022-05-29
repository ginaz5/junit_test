package com.course.mockito.data.business;

import com.course.mockito.data.api.TodoService;
import com.course.mockito.data.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
// cons of using stub - dynamic conditions, it will hard to maintain

public class TodoBusinessImplMockTest {

    @Test
    public void deleteTodosNotRelatedToSpring() {

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given - setup
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When - actual method call
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then - asserts
        verify(todoServiceMock).deleteTodo("Learn to Dance"); // it does call the method with arg string
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC"); // not call this method with arg string

        // use BDD
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");

        // capture args
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

    }

    @Test
    public void deleteTodosNotRelatedToSpring_ArgCaptureMultipleTimes() {

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given - setup
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn to Rock & Roll", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When - actual method call
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // capture args
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
        List<String> expected = Arrays.asList("Learn to Rock & Roll", "Learn to Dance");
        assertEquals(expected, stringArgumentCaptor.getAllValues());

    }

        @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        // Given - setup
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When - actual method call
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Then - asserts
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void retrieveTodosRelatedToSpring() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_withEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }

}