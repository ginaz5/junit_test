package com.course.mockito.data.business;

import com.course.mockito.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
// cons of using stub - dynamic conditions, it will hard to maintain

//@RunWith(MockitoJUnitRunner.class) // only junit class can have only one runner
public class TodoBusinessImplInjectMocksTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    // you can have multiple rules in a junit class

    @Mock
    TodoService todoServiceMock;
    // TodoService todoServiceMock = mock(TodoService.class);

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;
    // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;
    // ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Test
    public void deleteTodosNotRelatedToSpring() {

        // Given - setup
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

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

    }

    @Test
    public void deleteTodosNotRelatedToSpring_ArgCaptureMultipleTimes() {

        // Given - setup
        List<String> todos = Arrays.asList("Learn to Rock & Roll", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When - actual method call
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // capture args
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
        List<String> expected = Arrays.asList("Learn to Rock & Roll", "Learn to Dance");
        assertEquals(expected, stringArgumentCaptor.getAllValues());

        // use HamcrestMatcher
        assertThat(expected, hasItems("Learn to Rock & Roll", "Learn to Dance"));
    }

        @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        // Given - setup
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        // When - actual method call
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Then - asserts
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void retrieveTodosRelatedToSpring() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_withEmptyList() {
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }

}