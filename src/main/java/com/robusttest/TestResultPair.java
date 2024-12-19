package com.robusttest;

public class TestResultPair {
    private RobustTestCase testCase;
    private Throwable result = null;

    public TestResultPair(RobustTestCase robustTestCase, Throwable result) {
        this.testCase = robustTestCase;
        this.result = result;
    }

    public RobustTestCase getTest() {
        return testCase;
    }

    public Throwable getResult() {
        return result;
    }
}
