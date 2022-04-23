package com.course.junit.helper;

import org.junit.*;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before // is executed before every test
    public void setup() {
        System.out.println("--Before Test--");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @After // is executed after every test, e.g. to close db connection
    public void teardown() {
        System.out.println("--After  Test--");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

}
