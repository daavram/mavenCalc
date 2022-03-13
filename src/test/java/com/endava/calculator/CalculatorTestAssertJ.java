package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {

    private BasicOperations basicCalculator = new Basic();

    @Test
    public void shouldAddOneOperands() {

        //Given

        //When
        Long result = basicCalculator.add(167);

        //Then
        assertThat(result).isBetween(100L, 200L)
                .isGreaterThan(150L)
                .isNotNegative()
                .isNotNull()
                .isEqualTo(167L);
    }

}
