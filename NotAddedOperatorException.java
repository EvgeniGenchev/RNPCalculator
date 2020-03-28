package com.company;

public class NotAddedOperatorException extends RuntimeException{
    public NotAddedOperatorException(){
        super("Operator is missing from the RPN Calculator OperatorsData");
    }
}
