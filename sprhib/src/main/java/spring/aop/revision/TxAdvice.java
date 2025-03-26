package spring.aop.revision;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TxAdvice implements MethodInterceptor {

	
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Session ses=(Session) mi.getArguments()[0];
		Transaction tx=ses.beginTransaction();
		try {
			Object obj= mi.proceed();
			 tx.commit();	
			 return obj;
		}catch(Exception ex) {
			tx.rollback();
			throw new RuntimeException();
		} 
	}

}
