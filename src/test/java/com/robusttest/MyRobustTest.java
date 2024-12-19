package com.robusttest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MyRobustTest {

    @Test
    public void myRobustTest() {
        RobustTest test = new RobustTestCase("My Robust Test");

        assertThrows(UnsupportedOperationException.class, () -> test.run());
    }
    
}
