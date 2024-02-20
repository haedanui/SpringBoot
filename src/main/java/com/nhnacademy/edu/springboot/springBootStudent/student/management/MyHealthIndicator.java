package com.nhnacademy.edu.springboot.springBootStudent.student.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private final AtomicBoolean healthy = new AtomicBoolean(true);

    public void setUnhealthy(){
        this.healthy.set(false);
    }

    @Override
    public Health health() {
        if (healthy.get()) {
            return Health.up().withDetail("reason", "don't know").build();
        }
        return Health.down().withDetail("이유", "니가 하는게 다 그렇지 뭐").build();
    }

}
