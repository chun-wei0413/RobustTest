package com.robusttest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RobustTestCase implements RobustTest {
    String name;

    public RobustTestCase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final void run(RobustTestResult robustTestResult) {
        robustTestResult.startTest();
        setUp();
        try {
            runTest();
            robustTestResult.addSuccess(this);
        } catch (Throwable e) {
            robustTestResult.addFailure(this, e);
        }
        tearDown();
    }

    protected void setUp() {
    }

    protected void runTest() {
        Method runMethod = null;
        // Use Java Reflection to find the method with the given name
        try{
            runMethod = this.getClass().getDeclaredMethod(this.name);
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException("Unimplemented method 'runTest'");
        }
        // and invoke it
        try {
            runMethod.invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected void tearDown() {
    }
}
