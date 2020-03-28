package com.company;

public class ExpressionFormatException extends RuntimeException {
    public ExpressionFormatException(){
        super("Invalid expression format!");
    }
}
