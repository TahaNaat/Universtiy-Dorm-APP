package tn.esprit.sae7.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class AOPConfig {

    @After("execution(public * tn.esprit.sae7.service.*Impl.ajout*(String,..) throws Throwable)") // Type de advice
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("After method : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* tn.esprit.sae7.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Before method : " + joinPoint.getSignature().getName());
    }

    @Around("execution(* tn.esprit.sae7.service.*.*(..))")
    public Object calculTempsResponse(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime debut = LocalDateTime.now();
        Object obj = pjp.proceed();
        LocalDateTime fin = LocalDateTime.now();
        long duree = Duration.between(debut, fin).toMillis();

        log.info("Temps d'execution de la methode : " + pjp.getSignature().getName() + " est " + duree + " millisecondes");
        return obj;
    }
}
