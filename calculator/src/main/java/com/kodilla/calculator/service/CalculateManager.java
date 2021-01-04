package com.kodilla.calculator.service;

import com.kodilla.calculator.event.CalculationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculateManager implements ApplicationListener<CalculationEvent> {
    @Override
    public void onApplicationEvent(CalculationEvent event) {
        log.info("Calculation method: " + event.getCalculationName() + " invoked!");
    }
}
