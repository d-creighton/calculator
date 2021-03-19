package edu.ysu.dacreighton.calculator;

public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private Operator previousOperator;
    private Boolean clearInput;

    public Calculator() {
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.clearInput = false;
    }

    public void inputNumber(Integer number) {
        if (clearInput) {
            previousInput = input;
            input = number.toString();
            clearInput = false;
        }
        else if (input.equals(INITIAL_VALUE)) {
            input = number.toString();
        }
        else {
            input += number.toString();
        }
    }

    public void inputOperator(Operator operator) {
        if (this.operator != null) {
            this.calculateTotal();
            this.previousOperator = operator;
        }
        this.operator = operator;
        this.clearInput = true;
    }

    private void calculateTotal() {
        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);
        Double total = null;// = valueOne + valueTwo;
        //Do the math based on the operator
        //Switch statement
        switch (operator) {
            case Add:
                total = valueOne + valueTwo;
                break;
            case Subtract:
                total = valueOne - valueTwo;
                break;
            case Multiply:
                total = valueOne * valueTwo;
                break;
            case Divide:
                total = valueOne / valueTwo;
                break;
            case Equal:
                operator = previousOperator;
                calculateTotal();
                break;
        }
        input = total.toString();
    }

    public String getInput() {
        return this.input;
    }
}
