package com.robusttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MyRobustTest {

//    @Test
//    public void RobustTest() {
//        RobustTest test = new RobustTestCase("My Robust Test");
//        RobustTestResult result = new RobustTestResult();
//
//        assertEquals("My Robust Test", ((RobustTestCase) test).getName());
//
//        assertThrows(UnsupportedOperationException.class, () -> test.run(result));
//    }
//
//    @Test
//    public void RobustTestRun() {
//        RobustTest test = new RobustTestCase("My Robust Test");
//        RobustTestResult result = new RobustTestResult();
//
//        Exception ex = assertThrows(UnsupportedOperationException.class, () -> test.run(result));
//        assertEquals("Unimplemented method 'runTest'", ex.getMessage());
//    }

    @Test
    public void RobustTestResult() {
        RobustTest test = new RobustTestCase("My Robust Test");
        RobustTestResult result = new RobustTestResult();

        test.run(result);

        assertEquals(1, result.getCount());
        assertEquals("My Robust Test", result.getTestResultPair(0).getTest().getName());
        assertEquals(UnsupportedOperationException.class, result.getTestResultPair(0).getResult().getClass());
    }

    @Test
    public void runAnonymousAdapterTestCase() {
        RobustTest test = new SampleTestCase("Test1") {
            @Override
            protected void runTest() {
                test1();
            }
        };

        RobustTestResult result = new RobustTestResult();
        test.run(result);

        assertEquals(1, result.getCount());
        assertEquals("Test1", result.getTestResultPair(0).getTest().getName());
        assertEquals(null , result.getTestResultPair(0).getResult());

        test = new SampleTestCase("Test2") {
            @Override
            protected void runTest() {
                test2();
            }
        };

        test.run(result);
        assertEquals(2, result.getCount());
        assertEquals("Test2", result.getTestResultPair(1).getTest().getName());
        assertEquals(RuntimeException.class, result.getTestResultPair(1).getResult().getClass());
    }

    @Test
    public void runPluggableSelectorTestCase() {
        RobustTestResult result = new RobustTestResult();

        RobustTest test = new SampleTestCase("test1");
        test.run(result);

        RobustTest test2 = new SampleTestCase("test2");
        test2.run(result);

        assertEquals(2, result.getCount());
        assertEquals("test1", result.getTestResultPair(0).getTest().getName());
        assertEquals(null, result.getTestResultPair(0).getResult());
        assertEquals("test2", result.getTestResultPair(1).getTest().getName());
        assertEquals(RuntimeException.class, result.getTestResultPair(1).getResult().getClass());
    }

    @Test
    public void testSuite() {
        RobustTestSuite suite = new RobustTestSuite();
        suite.addTest(new SampleTestCase("test1"));
        suite.addTest(new SampleTestCase("test2"));

        RobustTestResult result = new RobustTestResult();
        suite.run(result);

        assertEquals(2, result.getCount());
        assertEquals("test1", result.getTestResultPair(0).getTest().getName());
        assertEquals(null, result.getTestResultPair(0).getResult());
        assertEquals("test2", result.getTestResultPair(1).getTest().getName());
        assertEquals(RuntimeException.class, result.getTestResultPair(1).getResult().getClass());
    }

    @Test
    public void testSuiteAddTestCase() {
        RobustTestSuite suite = new RobustTestSuite();
        suite.addTestCase(SampleTestCase.class);
        suite.addTestCase(SampleTestCase2.class);

        RobustTestResult result = new RobustTestResult();
        suite.run(result);

        assertEquals(4, result.getCount());
        assertEquals("test1", result.getTestResultPair(0).getTest().getName());
        assertEquals(null, result.getTestResultPair(0).getResult());
        assertEquals("test2", result.getTestResultPair(1).getTest().getName());
        assertEquals(RuntimeException.class, result.getTestResultPair(1).getResult().getClass());
        assertEquals("test3", result.getTestResultPair(2).getTest().getName());
        assertEquals(null, result.getTestResultPair(2).getResult());
        assertEquals("test4", result.getTestResultPair(3).getTest().getName());
        assertEquals(RuntimeException.class, result.getTestResultPair(3).getResult().getClass());
    }
}
