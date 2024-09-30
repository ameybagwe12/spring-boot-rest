package com.amey.spring_boot_rest.aop;

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

    // EVERY TIME ANY METHOD GETS CALLED LOGGER WILL BE PRINTED
    @Before("execution(* com.amey.spring_boot_rest.service.JobService.*(..))") // EXECUTION - FOR ALL METHODS
    public void logMethodCall(){
        LOGGER.info("Method called");
    }
}
