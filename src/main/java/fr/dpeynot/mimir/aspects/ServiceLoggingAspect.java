package fr.dpeynot.mimir.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {

    Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Before("execution(* fr.dpeynot.mimir.services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {}", joinPoint.getSignature());
    }

    @After("execution(* fr.dpeynot.mimir.services.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.debug("Exiting method: {}", joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* fr.dpeynot.mimir.services.*.*(..))",throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.error("Exception occurred in method: {}", joinPoint.getSignature(), ex);
    }

    @AfterReturning("execution(* fr.dpeynot.mimir.services.*.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        logger.debug("Exiting method with return value: {}", joinPoint.getSignature());
    }
}
