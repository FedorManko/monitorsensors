package org.manko.monitorsensors.aspect;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Class provides additional logic via AOP.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    /**
     * Method configure controller point cut.
     */
    @Pointcut("execution(public *  org.manko.monitorsensors.controller.*.*(..))")
    public void controllerLog() {

    }

    /**
     * Method configure service point cut.
     */
    @Pointcut("execution(public * org.manko.monitorsensors.service.*.*(..))")
    public void serviceLog() {
    }

    /**
     * Method create additional logic before controller calls.
     *
     * @param jp {@link JoinPoint}
     */
    @Before("controllerLog()")
    public void doBeforeController(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("""
                NEW REQUEST:
                IP : {}
                URL : {}
                HTTP_METHOD : {}
                CONTROLLER_METHOD : {}.{}""",
            request.getRemoteAddr(),
            request.getRequestURL().toString(),
            request.getMethod(),
            jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
    }

    /**
     * Method create additional logic before service calls.
     *
     * @param jp {@link JoinPoint}
     */
    @Before("serviceLog()")
    public void doBeforeService(JoinPoint jp) {
        log.info("RUN SERVICE:\n"
                + "SERVICE_METHOD : {}.{}",
            jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName());
    }

    /**
     * Method create additional logic after returning result.
     *
     * @param returnObject {@link Object}
     */
    @AfterReturning(returning = "returnObject", pointcut = "controllerLog()")
    public void doAfterReturning(Object returnObject) {
        log.info("""
                Return value: {}
                END OF REQUEST""",
            returnObject);
    }

    /**
     * Method create additional logic after throwing exception.
     *
     * @param jp {@link JoinPoint}
     * @param ex {@link Exception}
     */
    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void throwsException(JoinPoint jp, Exception ex) {
        log.error("Request throw an exception. Cause - {}. {}",
            Arrays.toString(jp.getArgs()), ex.getMessage());
    }

}