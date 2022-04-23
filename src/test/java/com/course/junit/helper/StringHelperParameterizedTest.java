package com.course.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs[][] = {
                {"AACD", "CD"},
                {"ACD", "CD"},
                {"AAAEQ", "AEQ"},
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void truncateAInFirst2Positions_AinFirst2Positions() {
        // you can use refactor to make inline variable
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }

}