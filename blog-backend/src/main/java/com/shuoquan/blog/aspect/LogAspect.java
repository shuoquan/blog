package com.shuoquan.blog.aspect;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private class RequestLog {

    public RequestLog(String url, String ip, String method, Object[] args) {
      this.url = url;
      this.ip = ip;
      this.method = method;
      this.args = args;
    }

    private final String url;

    @Override
    public String toString() {
      return "RequestLog{"
          + "url='"
          + url
          + '\''
          + ", ip='"
          + ip
          + '\''
          + ", method='"
          + method
          + '\''
          + ", args="
          + Arrays.toString(args)
          + '}';
    }

    private final String ip;
    private final String method;
    private final Object[] args;
  }

  @Pointcut("execution(* com.shuoquan.blog.controller.*.*(..))")
  public void log() {}

  @Before("log()")
  public void doBefore(JoinPoint joinPoint) {
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    String url = request.getRequestURL().toString();
    String ip = request.getRemoteAddr();
    String method =
        joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    RequestLog requestLog = new RequestLog(url, ip, method, args);
    logger.info("request info: "+ requestLog);
  }

  @After("log()")
  public void doAfter() {}

  @AfterReturning(returning = "result", pointcut = "log()")
  public void doAfterReturn(Object result) {
    logger.info("request return: "+ result);
  }
}
