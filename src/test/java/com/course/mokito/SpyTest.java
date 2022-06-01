package com.course.mokito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void mockAList() {
        List arrayListMock = mock(ArrayList.class);
        assertEquals(0, arrayListMock.size());
        doReturn(5).when(arrayListMock).size();
        arrayListMock.add("Dummy");
        assertEquals(5, arrayListMock.size());
    }
    @Test
    public void spyAList() {
        // with Spy you can use actual method
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy"); // check if add being called with parameter "Dummy"
        assertEquals(1, arrayListSpy.size());

        // the method of spy object can be mocked partially
        doReturn(5).when(arrayListSpy).size();
        assertEquals(5, arrayListSpy.size());
    }
}
