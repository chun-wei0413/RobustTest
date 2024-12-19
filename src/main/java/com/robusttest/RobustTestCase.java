package com.robusttest;

public class RobustTestCase implements RobustTest {
    String name;

    public RobustTestCase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final void run() {
        setUp();
        runTest();
        tearDown();
    }

    protected void setUp() {
    }

    protected void runTest() {
        throw new UnsupportedOperationException("Unimplemented method 'runTest'");
    }

    protected void tearDown() {
    }
}
