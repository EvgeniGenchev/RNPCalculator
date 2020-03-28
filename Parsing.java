package com.company;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parsing {
    private ArrayList<String> supportedOps;


    public Parsing(ArrayList<String> supportedOps) {
        this.supportedOps = supportedOps;
    }
    public Parsing() {
        this.supportedOps = startup();
    }

    private ArrayList<String> startup() {
        var supportedOps = new ArrayList<String>();
        supportedOps.add("+");
        supportedOps.add("-");
        supportedOps.add("*");
        supportedOps.add("^");
        supportedOps.add("sqrt");
        return supportedOps;
    }


    public boolean canParse(String userInput) {

        var list = this.parse(userInput);

        int counter = 0;

        try {
            if(valence(list.get(list.size()-1)) == 0){
                throw new ExpressionFormatException();
            }
            for (String token : list) {
                counter = counter - valence(token);
                if(!(isSupportedOpr(token)) & !isNumber(token)){
                    throw new NotSupportedOperatorException();
                }
                if(counter < 0 ){
                    throw new ExpressionFormatException();
                }
                counter ++;
            }

        }catch (ExpressionFormatException | IndexOutOfBoundsException e){
            System.out.println(new ExpressionFormatException().getMessage());
            return false;
        }catch (NotSupportedOperatorException ne){
            System.out.println(ne.getMessage());
            return false;
        }
        return true;
    }

    private int valence(String token){
        String operands = "+-/%*^";
        if(isNumber(token)){
            return 0;
        }
        else if(operands.contains(token)){
            return 2;
        }
        else{
            return 1;
        }
    }

    public ArrayList<String> parse(String string){
        StringTokenizer collection = new StringTokenizer(string);
        var list = new ArrayList<String>();
        while(collection.hasMoreTokens()){
            list.add(collection.nextToken());
        }
        return list;
    }

    public static boolean isNumber(String string){
        if(string == null){
            return false;
        }
        try{
            var a = Double.parseDouble(string);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean isSupportedOpr(String strOpr){
        for (String supportedOp : supportedOps) {
            if (strOpr.equals(supportedOp)) {
                return true;
            }
        }
        return false;
    }

}
