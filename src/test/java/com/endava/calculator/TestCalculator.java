package com.endava.calculator;

/**
 * Create an application that simulates a calculator:
 * The application should have two modes: Basic and Expert
 * The application should be able to add/substract/multiply/divide any number of integers, longs, double
 * The expert calculator should have the pow, root, n factorial; extra from the basic one
 * The calculators can be started with a desired number of floating points. By default it starts with 10 floating points
 * The advanced calculator can also evaluate string expressions, eg: 3+2*4
 *
 * @author daavram
 */

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {
    public static void main(String[] args) {

        //        Basic operations
        System.out.println("\n----------------------Basic operations----------------------");
        BasicOperations b = new Basic(3);
        System.out.println("Add 2, 3, 4, 5 result: " + b.add(2, 3, 4, 5));
        System.out.println("Substract 2, -3 result: " + b.substract(2, -3));
        System.out.println("Substract 2.2, -3.3 result: " + b.substract(2.2, -3.3));
        System.out.println("Multiply 2, 6 result: " + b.multiply(2, 6));
        System.out.println("Multiply 2, 3, 4 result: " + b.multiply(2, 3, 4));
        System.out.println("Divide 10, 3 result: " + b.divide(10, 3));
        System.out.println("Multiply 3.5, 2.3 result: " + b.multiply(3.5, 2.3));

        //        Expert operations
        System.out.println("\n----------------------Expert operations----------------------");
        ExpertOperations e = new Expert(3);
        System.out.println("Pow 2, 3 result: " + e.pow(2, 3));
        System.out.println("Pow 2, -1 result: " + e.pow(2, -1));
        System.out.println("Root 10 result: " + e.root(10));
        System.out.println("Root 7  result: " + e.root(7));
        System.out.println("Fact 5 result: " + e.fact(5));
        System.out.println("Fact 4 result: " + e.fact(4));
        System.out.println("Fact 5 recursive result: " + e.factRec(5));

        //        String operations
        System.out.println("\n----------------------String operations----------------------");
        System.out.println("Calcul 2+3 result: " + e.calculate("2+3"));
        System.out.println("Calcul 22+33 result: " + e.calculate("22+33"));
        System.out.println("Calcul 22.42+33.31 result: " + e.calculate("22.42+33.31"));
        System.out.println("Calcul 22.11 + 33.22 + 5 + 7 result: " + e.calculate("22.11 + 33.22 + 5 + 7"));
        System.out.println("Calcul -3-5*3 result: " + e.calculate("-3-5*3"));

        //        Brackets operations
        System.out.println("\n----------------------Brackets operations----------------------");
        System.out.println("Calcul 2*(3+2) result: " + e.calculate("2*(3+2)"));
        System.out.println("Calcul (-3+2)*2 result: " + e.calculate("(-3+2)*2"));
        System.out.println("Calcul 2*(-3+2) result: " + e.calculate("2*(-3+2)"));
        System.out.println("Calcul 2*(-3+2) result: " + e.calculate("(-3-5)/2"));
        System.out.println("Calcul 2 + (-3-5) result: " + e.calculate("2 + (-3-5)"));
        System.out.println("Calcul (3+2)/5*5-(8/2) result: " + e.calculate("(3+2)/5*5-(8/2)"));
        System.out.println("Calcul 2*(3+2)^2 result: " + e.calculate("2*(3+2)^2"));
    }

}
