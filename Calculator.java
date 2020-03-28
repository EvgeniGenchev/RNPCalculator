package com.company;


import java.util.ArrayList;

interface Calculator {
    double execute(ArrayList<String> expression);
    ArrayList<String> getOperationsINfo();
}
