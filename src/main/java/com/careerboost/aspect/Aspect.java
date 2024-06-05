package com.careerboost.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

	Log logger = LogFactory.getLog(Aspect.class);

	@Before("execution(*  com.careerboost.controllers.*Controller.*(..))")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.info("Entered");
		logger.info("Accessed " + methodName + "() method from " + className);

	}

	@After("execution(*  com.careerboost.controllers.*Controller.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("Exit");
	}

	@AfterThrowing(value = "execution(*  com.careerboost.controllers.*Controller.*(..))", throwing = "ex")
	public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {

		logger.info("Exception raised from the : " + ex.getClass());
		logger.info("Customized Message : " + ex.getMessage());
//		logger.info(ex.getStackTrace());
		logger.info("Exception stack trace: ", ex);

	}

}

