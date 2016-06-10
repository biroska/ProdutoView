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
		
		String parametersList = buildMethodsParameterString( joinPoint );

		logger.info("[" + joinPoint.getSignature().getDeclaringTypeName() + "." +
		                  joinPoint.getSignature().getName() + " ( " +
		                  parametersList + " ) ]" );
	}
	
	private String buildMethodsParameterString( JoinPoint joinPoint ){
		
		Object[] signatureArgs = joinPoint.getArgs();
		String args = "";
		int lastIndex = -1;
		
		if ( signatureArgs == null || signatureArgs.length == 0 ){
			return "";
		}
		
		for (Object obj : signatureArgs) {
			args += args + obj.getClass().getSimpleName() + ", ";
		}
		
		lastIndex = args.lastIndexOf(", ");
		
		if ( lastIndex > -1 ){
			args = args.substring(0, lastIndex );
		}
		
		return args;
	}

}