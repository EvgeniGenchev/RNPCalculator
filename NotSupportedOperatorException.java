package com.company;

public class NotSupportedOperatorException extends RuntimeException{
    public NotSupportedOperatorException(){
        super("Operand used in the expression is not supported!");
    }
}
