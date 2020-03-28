package com.company;

import java.util.Stack;

interface Operation {
    boolean isBinary();
    String getOperator();
    String getDescription();
    double execute(double... values);


}
