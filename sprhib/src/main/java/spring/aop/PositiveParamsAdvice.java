package spring.aop;

import java.util.Iterator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PositiveParamsAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("Inside Around Advice.....");
		Object [] args=mi.getArguments();
		for (int i = 0; i < args.length; i++) {
			args[i]= Math.abs((Integer)args[i]);
		}
		//before method call
		Object ret=  mi.proceed();
		//After method call
		System.out.println("After Returning");
		return ret;
	}

}
