package com.hebao.zdc.test.config;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.function.Predicate;

/*
 * @ClassName AdbAspect
 * @Description TODO
 * @Author XiaoAn
 * @Date 2021/1/22
 * @Version 1.0
 */
@Log4j2
@Aspect
@Component
public class AdbAspect {

    @Pointcut("execution(* com.hebao.zdc.test.controller.*.*(..))")
    private void adbPt(){}

    @Around( "adbPt()")
    private Object adbAd(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null){
            HttpServletRequest request = attributes.getRequest();
            Object[] args = joinPoint.getArgs();
            log.info("{} {} {}", request.getMethod(), request.getRequestURL().toString(),
                    Arrays.stream(args).filter(arg -> !(arg instanceof HttpServletRequest || arg instanceof HttpServletResponse)).toArray());
            Object proceed = joinPoint.proceed();
            log.info("请求处理时间：{}s，请求body：{}",(System.currentTimeMillis() - startTime)/1000.0,proceed);
            return proceed;
        }else {
            return "请求错误！";
        }
    }

}
