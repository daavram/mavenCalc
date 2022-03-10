package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestReporterExtension.class)
public class CalculatorIT {

    private BasicOperations basicCalculator;
    private ExpertOperations expertCalculator;


    @BeforeAll

    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownTest() {
        System.out.println("After All");
    }

    @BeforeEach

    public void setUpEachTest() {
        basicCalculator = new Basic();
        expertCalculator = new Expert();
        System.out.println("\nBefore Each");
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each");
    }

    @Tags({@Tag("smoke"), @Tag("UI")})
    @Test
    public void shouldAddNumbersGivenOperand0() {

        //Given

        //When
        Long result = basicCalculator.add(2, 0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddNegativeNumbers() {

        //Given

        //When
        Long result = basicCalculator.add(-2, -4);

        //Then
        System.out.println(result);
    }


    @Test
    public void shouldAddBigNumber() {

        //Given

        //When
        Long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddMoreThan2Operands() {

        //Given

        //When
        Long result = basicCalculator.add(4, 5, 6, 7);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {

        //Given

        //When
        Long result = basicCalculator.add();

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldAddOneOperands() {

        //Given

        //When
        Long result = basicCalculator.add(4);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyOneOperands() {

        //  Given

        //  When
        Long result = basicCalculator.multiply(4);

        //  Then
        System.out.println(result);
    }

    @Test
    public void shouldMultipyNoOperands() {

        //Given

        //When
        Long result = basicCalculator.multiply();

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultipyMoreThan2Operands() {

        //Given

        //When
        Long result = basicCalculator.multiply(4, 5, 6, 7);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {

        //Given

        //When
        Long result = basicCalculator.multiply(-2, -4);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldPowNegativeNumbers() {

        //Given

        //When
        Double result = expertCalculator.pow(-2, -4);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldPow0Base() {

        //Given

        //When
        Double result = expertCalculator.pow(0, 2);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldPow0Exponent() {

        //Given

        //When
        Double result = expertCalculator.pow(2, 0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldFactorialNegativeNumber() {

        //Given

        //When
        Long result = expertCalculator.fact(-5);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldFactorial0Number() {

        //Given

        //When
        Long result = expertCalculator.fact(0);

        //Then
        System.out.println(result);
    }

    @Test
    public void shouldFactorialpositiveNumber() {

        //Given

        //When
        Long result = expertCalculator.fact(4);

        //Then
        System.out.println(result);
    }
}
