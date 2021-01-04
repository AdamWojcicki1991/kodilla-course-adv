package com.kodilla.calculator.event;

import org.springframework.context.ApplicationEvent;

public class CalculationEvent extends ApplicationEvent {
    private final String calculationName;

    public CalculationEvent(Object source, String calculationName) {
        super(source);
        this.calculationName = calculationName;
    }

    public String getCalculationName() {
        return calculationName;
    }
}
