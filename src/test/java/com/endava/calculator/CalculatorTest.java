package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

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
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        //Given

        //When
        Long result = basicCalculator.add(a, b);

        //Then
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));
        return argumentsList;
    }

    @ParameterizedTest
    @CsvSource({"-1,-5", "-8,-9", "-8,-10"})
    public void shouldAddNegativeNumbers(long a, long b) {

        //Given

        //When
        Long result = basicCalculator.add(a, b);

        //Then
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("API")})
    @Test
    public void shouldAddBigNumber() {

        //Given

        //When
        Long result = basicCalculator.add(Integer.MAX_VALUE, 1);

        //Then
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvFileSource (resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a, int b, int c) {

        //Given

        //When
        Long result = basicCalculator.add(a,b,c);

        //Then
        System.out.println(result);
    }

    @Tag("smoke")
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
