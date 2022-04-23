package com.course.junit.helper;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import static org.junit.Assert.*;

public class StringHelperTest {

    @Test
    public void truncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        // you can use refactor to make inline variable
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
}