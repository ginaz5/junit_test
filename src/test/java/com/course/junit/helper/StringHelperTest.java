package com.course.junit.helper;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import static org.junit.Assert.*;

public class StringHelperTest {
    StringHelper helper = new StringHelper();

    @Test
    public void truncateAInFirst2Positions_AinFirst2Positions() {
        // you can use refactor to make inline variable
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void truncateAInFirst2Positions_AinFirstPosition(){
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
}