package com.course.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// if you want to run specified test classes
@RunWith(Suite.class)
@Suite.SuiteClasses({QuickBeforeAfterTest.class, StringHelperTest.class})
public class MyTestSuite {

}
