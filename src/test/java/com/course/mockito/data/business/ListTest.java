package com.course.mockito.data.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", listMock.get(0));
        assertEquals("in28Minutes", listMock.get(1));
    }

    @Test (expected = RuntimeException.class)
    public void letsMockList_ThrowAnException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something happened"));
        when(listMock.subList(anyInt(),5)).thenThrow(new RuntimeException("Something happened"));
        when(listMock.add(anyInt())).thenReturn(Boolean.TRUE); // Exercise - Mock other method
        listMock.get(0);
    }

    // Exercise - play around with argument matchers
    abstract class FlowerService {
        public abstract boolean isABigFlower(String name, int petals);
    }

    @Test
    public void Flower() {
        FlowerService mock = mock(FlowerService.class);
        // when(mock.isABigFlower("poppy", anyInt())).thenReturn(true); //Invalid use of argument matchers!
        when(mock.isABigFlower(eq("poppy"), anyInt())).thenReturn(true);
    }

    @Test
    public void letsMockListGet_usingBDD() {
        // Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("in28Minutes");

        // When
        String firstElement = listMock.get(0);

        // Then
        assertThat(firstElement, is("in28Minutes"));
    }

}
