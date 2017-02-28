package com.amaris;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        System.out.println("SetUp");
    }

    @Test
    public void whenRunCalculateThenHisValuesIsZero(){
        assertEquals(BigDecimal.ZERO, calculator.getValue());
    }

    @Test
    public void testSetValue(){
        BigDecimal valor = new BigDecimal( 34 );
        calculator.setValue(valor);
        assertEquals(valor, calculator.getValue());
    }

    @Test
    public void addStringVoid(){
        int result = 0;
        String numbers = "";
        assertEquals(result, calculator.add(numbers));
    }

    @Test
    public void addString1number(){
        int result = 2;
        String numbers = "2";
        assertEquals(result, calculator.add(numbers));
    }

    @Test
    public void addStringArray(){
        int result = 12;
        String numbers = "4,8";
        assertEquals(result, calculator.add(numbers));
    }

    @Test
    public void addStringArrayWithMorePatterns(){
        int result = 9;
        String numbers = ";\n7;2";
        assertEquals(result, calculator.add(numbers));
    }

    @Test
    public void addStringArrayWithNegatives(){
        int result = -1;
        String numbers = "-1,-2,-3,-4";
        assertEquals(result, calculator.add(numbers));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
