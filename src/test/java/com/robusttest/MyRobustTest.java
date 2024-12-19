package com.robusttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MyRobustTest {

    @Test
    public void myRobustTest() {
        RobustTest test = new RobustTestCase("My Robust Test");

        assertEquals("My Robust Test", ((RobustTestCase) test).getName());
        
        assertThrows(UnsupportedOperationException.class, () -> test.run());
    }

    @Test
    public void myRobustTestRun() {
        RobustTest test = new RobustTestCase("My Robust Test");
        Exception ex = assertThrows(UnsupportedOperationException.class, () -> test.run());
        assertEquals("Unimplemented method 'runTest'", ex.getMessage());
    }
}
