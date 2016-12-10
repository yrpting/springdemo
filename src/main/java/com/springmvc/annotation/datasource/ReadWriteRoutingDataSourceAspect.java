package com.springmvc.annotation.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

@Aspect
public class ReadWriteRoutingDataSourceAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadWriteRoutingDataSourceAspect.class);

	@Pointcut("execution(* com.springmvc.*.dao.*.*(..))")
	public void daoPointcut() {
	}

	@Before("daoPointcut()")
	public void before(JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Class<?> clazz = target.getClass();

		Master master = (Master) AnnotationUtils.findAnnotation(method, Master.class);
		Slave slave = (Slave) AnnotationUtils.findAnnotation(method, Slave.class);

		if ((master == null) && (slave == null)) {
			master = (Master) AnnotationUtils.findAnnotation(clazz, Master.class);
			slave = (Slave) AnnotationUtils.findAnnotation(clazz, Slave.class);
		}

		if ((master != null) && (slave != null)) {
			throw new IllegalArgumentException("不能同时指定MASTER和SLAVE");
		}

		String routingDataSourceType = master == null ? RoutingDataSourceType.SLAVE.toString() : slave == null ? null : RoutingDataSourceType.MASTER.toString();

		if (routingDataSourceType == null) {
			RoutingDataSource routingDataSource = (RoutingDataSource) AnnotationUtils.findAnnotation(method, RoutingDataSource.class);
			if (routingDataSource == null) {
				routingDataSource = (RoutingDataSource) AnnotationUtils.findAnnotation(clazz, RoutingDataSource.class);
			}

			if (routingDataSource != null) {
				routingDataSourceType = routingDataSource.type().toString();
			}
		}

		if (routingDataSourceType == null) {
			routingDataSourceType = RoutingDataSourceType.MASTER.toString();
		}

		ReadWriteRoutingDataSourceHolder.put(routingDataSourceType);

		if (LOGGER.isDebugEnabled()) {
			String interfaceName = clazz.getInterfaces().length > 0 ? clazz.getInterfaces()[0].getName() : "UNKNOWN";

			LOGGER.debug("***** [" + interfaceName + "." + method.getName() + "] route DataSource to " + routingDataSourceType + " *****");
		}
	}
}