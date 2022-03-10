package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations {

    private String[] operators = {"+", "-", "%", "*", "/", "^"}; // ultima operatie din array va fi cea mai prioritara datorita recursivitatii

    public Expert() {
        decimals = 10;
    }

    public Expert(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public double pow(double base, double exponent) {
        double result = 1;
        for (int i = 1; i <= Math.abs(exponent); i++) {  // math.abs pentru modul in cazul in care exponent este negativ
            result *= base;
        }
        if (exponent >= 0) {
            return result;
        } else {
            return formatNumber(1 / result);//  pentru modul in cazul in care exponent este negativ
        }
    }

    @Override
    public double root(int a) {
        return formatNumber(Math.sqrt(a));
    }

    @Override
    public long fact(int n) {
        long result = 1;
        try {
            if (n > 0) {
                for (int i = 1; i <= n; i++) {
                    result *= i;
                }
                return result;
            } else {
                System.out.println("You cannot calculate factorial less or equol to 0");
                return 0;
            }
        } catch (IllegalArgumentException exception) {
        }
        return result;
    }

    @Override
    public long factRec(int n) {
        long result = 1;
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return n * factRec(n - 1);
        } else {
            throw new IllegalArgumentException("You cannot calculate factorial for negativ number");
        }
    }

    @Override
    public double calculate(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            if (s.contains("(")) {
                int startIndex = s.indexOf("(");
                int endIndex = s.indexOf(")");
                String left = s.substring(0, startIndex);
                String right = s.substring(endIndex + 1);
                String center = s.substring(startIndex + 1, endIndex);
                double result = calculate(center);
                return calculate(left + result + right);
            } else {

                for (String o : operators) {
                    int index = s.lastIndexOf(o);
                    if (index == -1) {
                        continue;
                    }
                    String leftSide = s.substring(0, index);
                    if (index != 0 && (leftSide.trim().charAt(leftSide.trim().length() - 1) == '+' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '-' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '*' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '/' || leftSide.trim().charAt(leftSide.trim().length() - 1) == '^')) {
                        continue;
                    }
                    Double leftOperand = index == 0 ? 0.0 : calculate(leftSide);
                    Double rightOperand = calculate(s.substring(index + 1));

                    switch (o) {
                        case "+":
                            return add(leftOperand, rightOperand);
                        case "-":
                            return substract(leftOperand, rightOperand);
                        case "/":
                            return divide(leftOperand, rightOperand);
                        case "*":
                            return multiply(leftOperand, rightOperand);
                        case "^":
                            return pow(leftOperand, rightOperand);
                        case "%":
                            return formatNumber(leftOperand % rightOperand);
                        default:
                            throw new IllegalArgumentException("Invalid operator " + o);
                    }

                }
                throw new RuntimeException("Operators field needs to have a value");
            }
        }

    }
}
