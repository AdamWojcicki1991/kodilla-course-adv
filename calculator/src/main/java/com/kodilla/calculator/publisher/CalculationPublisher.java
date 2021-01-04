package com.kodilla.calculator.publisher;

import com.kodilla.calculator.domain.CalculationType;
import com.kodilla.calculator.event.CalculationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public final class CalculationPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(CalculationType calculationType) {
        publisher.publishEvent(new CalculationEvent(this, calculationType.toString()));
    }
}
