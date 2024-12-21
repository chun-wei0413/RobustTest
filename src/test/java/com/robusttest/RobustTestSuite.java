package com.robusttest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RobustTestSuite implements RobustTest {
    private List<RobustTest> tests = new ArrayList<RobustTest>();

    public RobustTestSuite() {
    }

    @Override
    public void run(RobustTestResult robustTestResult) {
        for (RobustTest test : tests) {
            test.run(robustTestResult);
        }
    }

    public void addTest(RobustTest test) {
        tests.add(test);
    }

    //this is for real test classes
    public <T extends RobustTestCase> void addTestCase(Class<T> class1) {
        List<String> testNames = new ArrayList<String>();
        for (Method m : class1.getDeclaredMethods()) {
            if (m.getName().startsWith("test")) {
                testNames.add(m.getName());
            }
        }

        testNames.sort(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        for (String testName : testNames) {
            try {
                RobustTestCase testCase = class1.getConstructor(String.class).newInstance(testName);
                addTest(testCase);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
