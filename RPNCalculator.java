package com.company;

import java.util.ArrayList;

import java.util.Stack;

public class RPNCalculator implements Calculator {

    private ArrayList<Operation> operations;

    public RPNCalculator() {
        this.operations = exampleOperations();
    }

    public ArrayList<Operation> exampleOperations(){
        var exampleTest = new ArrayList<Operation>();
        exampleTest.add(new Addition());
        exampleTest.add(new Subtract());
        exampleTest.add(new Multiplication());
        exampleTest.add(new Root());
        exampleTest.add(new Power());
        return exampleTest;
    }

    public boolean addOperation(Operation operation){
        if(operations.contains(operation)){
            return false;
        }
        operations.add(operation);
        return true;
    }

    public boolean removeOperation(Operation operation){
        if(operations.contains(operation)){
            return false;
        }
        operations.remove(operation);
        return true;
    }

    // I decided that it is better for the program to return to types of info either which operation we have used
    // or the operation was just not found
    public int supportsOperation(String operator){
        for (int i = 0; i <operations.size() ; i++) {
            if(operations.get(i).getOperator().equals(operator)){
                return i;
            }
        }
        throw new NotAddedOperatorException();
    }

    @Override
    public double execute(ArrayList<String> expression) {

        var stack = new Stack<Double>();
        try {
            for (String element : expression) {
                // First the program checks if the element is an number and pushes it into the stack
                if (Parsing.isNumber(element)) {
                    stack.push(Double.parseDouble(element));
                }
                else {
                    // than checks if it is an operation nad gets the Operation from the operation list
                    // if there is no such added operation it throws an exception
                    var operation = operations.get(supportsOperation(element));
                    // if the size is one it is an unary expression if no it is normal
                    if(stack.size()== 1){
                        // the program executes the operation and puts it as only item in the stack
                        var result = operation.execute(stack.get(0));
                        stack.pop();
                        stack.push(result);
                    }else{
                        // if it has more than 1 numbers it is a normal operation so it passes the 2 by 2 the elements
                        // of the stack. When it reaches one it means we have only an result in the stack
                        while (stack.size() != 1) {
                            var result = operation.execute(stack.get(0), stack.get(1));
                            stack.pop(); stack.pop(); stack.push(result);

                        }
                    }
                }
            }
        } catch(NotAddedOperatorException ie) {
            System.out.println(ie.getMessage());

        }
        // at the end the only item in the stack should be an result
        return stack.get(0);
    }

    @Override
    public ArrayList<String> getOperationsINfo() {
        var description = new ArrayList<String>();
        for (Operation operation: operations) {
            description.add(operation.getOperator() + " --> " + operation.getDescription());
        }
        return description;
    }
}
