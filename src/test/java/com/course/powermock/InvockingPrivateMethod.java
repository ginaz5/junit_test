package com.course.powermock;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
// cons of using stub - dynamic conditions, it will hard to maintain

@RunWith(PowerMockRunner.class)
public class InvockingPrivateMethod {

    // Mock static method
    // Specific Runner, initialize UtilityClass.class, mock

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void mockStaticMethod() throws Exception {

        List<Integer> stats = Arrays.asList(1, 2, 3);
        when(dependency.retrieveAllStats()).thenReturn(stats); // mock the method
        // need to make sure that versions are aligned
        // https://stackoverflow.com/questions/27136752/powermock-throws-nosuchmethoderror-setmockname

//        long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
//        assertEquals(6, result);
    }

}