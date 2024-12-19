package com.robusttest;

public class NormalTestCase extends RobustTestCase {
    public NormalTestCase(String name) {
        super(name);
    }

    @Override
    protected void runTest() {
        //do nothing
    }

    public void test1() {
        // success
    }

    public void test2() {
        throw new RuntimeException("Test2 Failed");
    }
}
