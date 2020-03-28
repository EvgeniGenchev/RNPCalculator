package com.company;

import java.util.Scanner;

public class Input {
    private String input;

    public Input() {
        this.input = "";
    }

    public String getInput() {
        return input;
    }

    public boolean hasInput(){
        var scanner = new Scanner(System.in);
        this.input = scanner.nextLine();
        return true;
    }
}