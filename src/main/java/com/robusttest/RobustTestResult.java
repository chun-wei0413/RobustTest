package com.robusttest;

import java.util.ArrayList;
import java.util.List;

public class RobustTestResult {
    int count;
    List<TestResultPair> testResultPairs;

    public RobustTestResult() {
        count = 0;
        testResultPairs = new ArrayList<>();
    }

    public void startTest() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public TestResultPair getTestResultPair(int i) {
        return testResultPairs.get(i);
    }

    public void addSuccess(RobustTestCase robustTestCase) {
        TestResultPair testResultPair = new TestResultPair(robustTestCase, null);

        testResultPairs.add(testResultPair);
    }

    public void addFailure(RobustTestCase robustTestCase, Throwable e) {
        TestResultPair testResultPair = new TestResultPair(robustTestCase, e);

        testResultPairs.add(testResultPair);
    }
}
