package com.course.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BooleanParameterizedTest {

    StringHelper helper = new StringHelper();

    private String input;


    public BooleanParameterizedTest(String input) {
        this.input = input;
    }

    @Parameters
    public static String[] testConditions() {
        String expectedOutputs[] = {
                "ADAD",
                "ABAB",
                "AB",
                "AA",
                "A"
        };
        return expectedOutputs;
    }
    @Test
    public void areFirstAndLastTwoCharactersTheSame(){

        // with inline variable and use assertFalse
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame(input));
    }

}