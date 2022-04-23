package com.course.junit.helper;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ArraysCompareTest {

    @Test
    public void testArraySort_RandomArray() {
        int [] numbers = {12, 3, 4,1};
        int [] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }
}
