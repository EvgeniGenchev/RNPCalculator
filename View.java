package com.company;

import java.util.ArrayList;

public class View {
    private ArrayList<String> helpOptions;

    public View() {
        this.helpOptions = null;
    }

    public void showResult(String result){
        if(result.equals("h")){
            showOptions(this.helpOptions);
        }else if(result.equals("q")){
            System.out.println("Calculator is quitting. Good bye.");
        }else
        System.out.println("Result: " + result);
    }

    public void showOptions(ArrayList<String> options){

        this.helpOptions = options;

        System.out.println("RPNCalculator help\n" +
                "The following operations in RPN are supported:\n");
        for (String option:options){
            System.out.println(option);
        }
        System.out.println("Enter 'h' to get help.\n" +
                "Enter 'q' to exit the program.\n\n");

    }

    public void hello(){
        System.out.println("\t\tHello, user!\n" +
                "\tWelcome to my Postfix Calculator\n");
        System.out.println("\t\tEnter 'h' to get help.\n" +
                "\t\tEnter 'q' to exit the program.\n\n");
    }
}
