package com.robusttest;

public class SampleTestCase extends RobustTestCase {
    public SampleTestCase(String name) {
        super(name);
    }

//    @Override
//    protected void runTest() {
//        if you override runTest, you will miss the reflection in parent class
//    }

    public void test1() {
        // success
    }

    public void test2() {
        throw new RuntimeException("test2 Failed");
    }
}
