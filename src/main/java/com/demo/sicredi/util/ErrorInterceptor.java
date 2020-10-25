package com.demo.sicredi.util;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class ErrorInterceptor{
    private static Logger logger = Logger.getLogger("com.cwi.demo.service");

    @AfterThrowing(pointcut = "com.cwi.demo.*", throwing = "ex")
    public void errorInterceptor(Exception ex) {

        // DO SOMETHING HERE WITH EX
        logger.log(Level.SEVERE,"",ex);



    }
}