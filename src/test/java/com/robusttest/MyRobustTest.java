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
    public void NormalTestCase() {
        RobustTest test = new NormalTestCase("Test1") {
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

        test = new NormalTestCase("Test2") {
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
}
