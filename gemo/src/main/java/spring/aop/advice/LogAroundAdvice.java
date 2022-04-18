package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			
		long start = System.currentTimeMillis();

		//---기존 업무-----------------------------------------------------
		Object result = invocation.proceed();		
		//---기존 업무-----------------------------------------------------
		
		long end = System.currentTimeMillis();
		String message = (end - start) + "ms";
		 
		System.out.println(message);
		
		return result;
	}

}
