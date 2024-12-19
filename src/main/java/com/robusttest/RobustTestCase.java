package com.robusttest;

public class RobustTestCase implements RobustTest {
    String name;

    public RobustTestCase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
