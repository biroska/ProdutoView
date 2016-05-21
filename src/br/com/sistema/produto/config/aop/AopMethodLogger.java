package br.com.sistema.produto.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopMethodLogger {

	@Before("!execution(* br.com.sistema.produto.config..*(..)) && " +  // Não capturar classes do pacote de de configuracao 
			"!execution(* br.com.sistema.produto.model..*(..)) && " +   // Não capturar classes do pacote de de configuracao 
            "execution(* br.com.sistema.produto..*(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("******");
		System.out.println("Class : " + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("method : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

}