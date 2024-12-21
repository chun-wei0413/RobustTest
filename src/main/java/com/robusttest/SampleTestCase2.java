package com.robusttest;

public class SampleTestCase2 extends RobustTestCase {
    public SampleTestCase2(String name) {
        super(name);
    }

    public void test3() {
        // success
    }

    public void test4() {
        throw new RuntimeException("test4 Failed");
    }
}
