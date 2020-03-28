package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {


        var controller = new Controller(new RPNCalculator(), new Parsing(), new View(), new Input());
        controller.run();
    }
}
//        var a = new ArrayList<String>();
//        a.add("2");
//        a.add("2");
//        a.add("2");
//        a.add("^");
//        a.add("4");
//        a.add("+");
//        a.add("10");
//        a.add("-");
//        a.add("5");
//        a.add("*");
//        a.add("1");
//        a.add("-");
//        a.add("sqrt");
//
//
//        var d = new ArrayList<Operation>();
//        d.add(new Addition());
//        d.add(new Subtract());
//        d.add(new Multiplication());
//        d.add(new Root());
//        d.add(new Power());
//        var c = new RPNCalculator(d);
//
//        var result = c.execute(a);
//        System.out.println();
//        System.out.println(result);
