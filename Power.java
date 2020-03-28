package com.company;

public class Power implements Operation {

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String getOperator() {
        return "^";
    }

    @Override
    public String getDescription() {
        return "performs exponentiation, first operand to the power of the second";
    }

    @Override
    public double execute(double... values) {
        var result = values[0];
        for (int i = 1; i <values.length ; i++) {
            result = Math.pow(result, values[1]);
        }
        return result;
    }
}
