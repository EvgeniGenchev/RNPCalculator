package com.company;

public class Subtract implements Operation {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public String getDescription() {
        return "subtracts the second operand from the first";
    }

    @Override
    public double execute(double... values) {
        var result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = result - values[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "Subtract";
    }
}
