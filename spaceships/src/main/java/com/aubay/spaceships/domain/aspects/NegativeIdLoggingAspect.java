package com.aubay.spaceships.domain.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipRequest;

@Aspect
@Component
public class NegativeIdLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(NegativeIdLoggingAspect.class);

    @Before("execution(* com.aubay.spaceships.application.command.getspaceship.GetSpaceship.handle(..)) && args(getSpaceshipRequest)")
    public void logNegativeId(GetSpaceshipRequest getSpaceshipRequest) {
        if (getSpaceshipRequest.getId() < 0) {
        	System.out.println("error error");
            logger.warn("Error, you can't ask for a spaceship with a negative ID: {}", getSpaceshipRequest.getId());
        }
    }
}

