package com.company;

public class Multiplication implements Operation {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public String getDescription() {
        return "performs multiplication of two operands";
    }

    @Override
    public double execute(double... values) {
        var result = 1.0;
        for (double value:values) {
            result = result * value;
        }
        return result;
    }


}
