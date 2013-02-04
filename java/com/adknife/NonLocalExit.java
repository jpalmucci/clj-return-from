package com.adknife;

// This class is necessary because we need a named class that extends Throwable in order to catch.
// proxy can extend throwable, but doesn't give a named class
public class NonLocalExit extends java.lang.Throwable {
    public NonLocalExit(Object blockName, Object result) {
        this.result = result;
        this.blockName = blockName;
    }
    public Object getResult() { return result; };
    public Object getBlockName() { return blockName; };
    private Object result,blockName;
};


