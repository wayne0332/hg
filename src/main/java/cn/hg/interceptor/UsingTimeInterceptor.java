package cn.hg.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UsingTimeInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsingTimeInterceptor.class);

	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * cn.hg.controller.*.*(..))")
	public Object calculateUsingTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		LOGGER.info("{}#{} using time:{}ms"
				, proceedingJoinPoint.getTarget().getClass().getSimpleName()
				, ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getName()
				, System.currentTimeMillis() - startTime);
		return result;
	}
}
