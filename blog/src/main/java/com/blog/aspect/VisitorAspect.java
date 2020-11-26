package com.blog.aspect;

import com.blog.pojo.Visitor;
import com.blog.service.VisitorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class VisitorAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    VisitorService visitorService;

    Visitor visitor=new Visitor();

    @Pointcut("execution(* com.blog.controller.*.*(..))")        //定义切入点表达式
    public void visitor(){}

    @Before("visitor()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteAddr();
        visitor.setIp(ip);
        visitorService.insertVisitor(visitor);
    }

    @Data
    @AllArgsConstructor
    public class RequestLog{      //用于封装请求信息
        private String ip;
    }
}
