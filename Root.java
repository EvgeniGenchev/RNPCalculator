package com.company;

public class Root implements Operation {
    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public String getOperator() {
        return "sqrt";
    }

    @Override
    public String getDescription() {
        return "calculates the root of an operand";
    }

    @Override
    public double execute(double... values) {
        return Math.sqrt(values[0]);
    }
}
