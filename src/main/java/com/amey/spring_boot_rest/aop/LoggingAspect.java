package com.amey.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect // FOR AOP - ASPECT ORIENTED PROGRAMMING
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /* EXPRESSIONS WHICH CAN BE USED FOR AOP
    * Return type - * -> FOR ALL RETURN TYPE
    * Class name (Complete Path) - * -> FOR ALL CLASS
    * .Method name - .* -> FOR ALL METHODS
    * (Arguments) - (..) -> FOR ALL ARGS
    * */

    // EVERY TIME ANY METHOD GETS CALLED LOGGER WILL BE PRINTED BEFORE EXECUTION
    // || -> OR
    @Before("execution(* com.amey.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.amey.spring_boot_rest.service.JobService.returnAllJobPosts(..))") // EXECUTION - FOR ALL METHODS
    public void logMethodCall(JoinPoint jp){
        // GETTING HOLD OF METHOD getJob() USING JOIN POINT
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    // EVERY TIME ANY METHOD GETS CALLED LOGGER WILL BE PRINTED AFTER EXECUTION
    @After("execution(* com.amey.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.amey.spring_boot_rest.service.JobService.returnAllJobPosts(..))")
    public void logMethodExecute(JoinPoint jp){
        LOGGER.info("Method executed: " + jp.getSignature().getName());
    }

    // FOR CATCHING ERRORS IF EXCEPTION IS PRESENT
    @AfterThrowing("execution(* com.amey.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.amey.spring_boot_rest.service.JobService.returnAllJobPosts(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method crashed with issues: " + jp.getSignature().getName());
    }
}
