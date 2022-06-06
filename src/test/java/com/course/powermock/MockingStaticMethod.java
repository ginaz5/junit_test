package com.course.powermock;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
// cons of using stub - dynamic conditions, it will hard to maintain

@RunWith(MockitoJUnitRunner.class)
public class MockingStaticMethod {

    // Mock static method
    // Specific Runner, initialize UtilityClass.class, mock

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void mockStaticMethod() {
        List<Integer> stats = Arrays.asList(1, 2, 3);

        when(dependency.retrieveAllStats()).thenReturn(stats); // mock the method

        MockedStatic mockedStatic = mockStatic(UtilityClass.class); // mock static method
        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(150, result);
    }

    @Test
    public void mockStaticMethod_Verify() {
        List<Integer> stats = Arrays.asList(1, 2, 3);

        when(dependency.retrieveAllStats()).thenReturn(stats); // mock the method

        MockedStatic mockedStatic = mockStatic(UtilityClass.class); // mock static method
        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(150, result);
        mockedStatic.verify(
                () -> UtilityClass.staticMethod(6)
        );
    }
}