package com.karthikr;

public class Main {

    public static void main(String[] args) {
        // write your code here
        InputOutputUtil.outputString("Enter the description");
        String description = InputOutputUtil.inputString();

        BracketInspector bracketInspector = new BracketInspector(description);

        InputOutputUtil.outputString("SimpleMode -->" + bracketInspector.simpleMode());
        InputOutputUtil.outputString("ComplexMode -->" + bracketInspector.complexMode());
    }
}
