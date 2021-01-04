package com.kodilla.calculator.processor;

import org.springframework.stereotype.Service;

import java.util.function.DoubleBinaryOperator;

@Service
public final class CalculateProcessor {
    public static final DoubleBinaryOperator ADDITION = (left, right) -> left + right;
    public static final DoubleBinaryOperator SUBTRACTION = (left, right) -> left - right;
    public static final DoubleBinaryOperator MULTIPLICATION = (left, right) -> left * right;
    public static final DoubleBinaryOperator DIVIDED = (left, right) -> left / right;

    public double calculate(double firstNumber, double secondNumber, DoubleBinaryOperator doubleBinaryOperator) {
        return doubleBinaryOperator.applyAsDouble(firstNumber, secondNumber);
    }
}
