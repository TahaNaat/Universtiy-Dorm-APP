package tn.esprit.sae7.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class AOPConfig {
    @After("execution(public * tn.esprit.sae7.service.*Impl.ajout*(String,..) throws Throwable)")//type de advice
    @Before("execution(* tn.esprit.sae7.service.*.*(..))")
    void aspect(JoinPoint joinPoint) {
        log.info("In method : " + joinPoint.getSignature().getName());//
    }
    @Around("execution(* tn.esprit.sae7.service.*.*(..))")
    Object calculTempsResponse(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime debut = LocalDateTime.now();
        Object obj = pjp.proceed();
        LocalDateTime fin = LocalDateTime.now();
        long duree = fin.getSecond()-debut.getSecond();
        log.info("Temps d'execution de la methode : "+ pjp.getSignature().getName()+"est" + duree + " secondes");
        return obj;
    }
}   
