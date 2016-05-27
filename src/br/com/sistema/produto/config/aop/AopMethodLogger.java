package br.com.sistema.produto.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopMethodLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(AopMethodLogger.class);

	@Before("!execution(* br.com.sistema.produto.config..*(..)) && " +  // Não capturar classes do pacote de de configuracao 
			"!execution(* br.com.sistema.produto.model..*(..)) && " +   // Não capturar classes do pacote de de configuracao 
            "execution(* br.com.sistema.produto..*(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("******");
		System.out.println("Class : " + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("method : " + joinPoint.getSignature().getName());
		System.out.println("******");
		
		String name = "lordofthejars";

		logger.info("Hello from Bar.");

		logger.debug("In bar my name is {}.", name);
		
		logger.error("com.lordofthejars.foo {}", "TESTE....");
		
	}

}