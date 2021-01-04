package com.kodilla.calculator.controller;

import com.kodilla.calculator.processor.CalculateProcessor;
import com.kodilla.calculator.publisher.CalculationPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.kodilla.calculator.domain.CalculationType.*;
import static com.kodilla.calculator.processor.CalculateProcessor.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculators")
public final class CalculatorController {
    private final CalculationPublisher publisher;
    private final CalculateProcessor calculateProcessor;

    @PostMapping("/add")
    public double add(@RequestParam final double firstNumber, @RequestParam final double secondNumber) {
        publisher.publish(ADD);
        return calculateProcessor.calculate(firstNumber, secondNumber, ADDITION);
    }

    @PostMapping("/subtract")
    public double subtract(@RequestParam final double firstNumber, @RequestParam final double secondNumber) {
        publisher.publish(SUBTRACT);
        return calculateProcessor.calculate(firstNumber, secondNumber, SUBTRACTION);
    }

    @PostMapping("/multiply")
    public double multiply(@RequestParam final double firstNumber, @RequestParam final double secondNumber) {
        publisher.publish(MULTIPLY);
        return calculateProcessor.calculate(firstNumber, secondNumber, MULTIPLICATION);
    }

    @PostMapping("/divide")
    public double divide(@RequestParam final double firstNumber, @RequestParam final double secondNumber) {
        publisher.publish(DIVIDE);
        return calculateProcessor.calculate(firstNumber, secondNumber, DIVIDED);
    }
}
