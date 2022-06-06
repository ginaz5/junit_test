package com.course.powermock;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
// cons of using stub - dynamic conditions, it will hard to maintain

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructor {

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Mock
    ArrayList mockList;

    @Test
    public void mockStaticMethod() throws Exception {

        when(mockList.size()).thenReturn(5);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();
        assertEquals(5, size);
    }

}