package com.company;

public class Controller {
    private Calculator calc;
    private Parsing parser;
    private View view;
    private Input input;

    public Controller(Calculator calc, Parsing parser, View view, Input input) {
        this.calc = calc;
        this.parser = parser;
        this.view = view;
        this.input = input;
    }
    public void run(){

        view.hello();

        String userInput = input.getInput();
        try {
            while (!input.getInput().equals("q")) {

                var flag = false;
                while (!flag) {

                    input.hasInput();

                    userInput = input.getInput();

                    if (userInput.equals("h")) {
                        view.showOptions(calc.getOperationsINfo());
                    } else if (userInput.equals("q")) {
                        throw new escape();
                    } else {
                        flag = parser.canParse(userInput);

                    }
                }
                var userInputList = parser.parse(userInput);
                var answer = calc.execute(userInputList);
                view.showResult(String.valueOf(answer));
            }
        }catch (escape e){
            view.showResult("q");
        }
    }
}
