package spring.aop;

import java.lang.reflect.Method;
import java.util.*;


import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice{
	public Map<String,Integer> counters;
	
	public void any() {
		System.out.println("Initialize counterrs.....");
		counters=new HashMap<String,Integer>();
	}
	
	public void any1() {
		System.out.println("Counters= "+counters);
	}
	
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Method=" +method + "With Args=" +args+Arrays.toString(args));
		String methodName=method.getName();
		if(counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName)+1);
		}else {
			counters.put(methodName, 1);

		}
		
	}
}
