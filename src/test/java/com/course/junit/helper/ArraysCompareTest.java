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

    // expected null pointer exception
    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100) // use timeout to control performance
    public void testSort_Performance() {
        int[] array = {4,6,77,8,10,3,5,85,91};
        for (int i = 1; i <= 1000000; i++){
            array[0] = i;
            Arrays.sort(array);
        }
    }

}
