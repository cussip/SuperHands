package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;

public class Program {

	public static void main(String[] args) {
				
		ApplicationContext context = 
//				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
		
		Exam exam = (Exam) context.getBean("exam");
		
		System.out.printf("total is %d\n", exam.total());	
		System.out.printf("avg is %f\n", exam.avg());		
				
//		Exam exam = new NewlecExam(1,1,1,1);
//		
//		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
//				new Class[] {Exam.class},
//				new InvocationHandler() {
//					
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						
//						long start = System.currentTimeMillis();
//						
//						//---기존 업무-----------------------------------------------------
//					   	Object result = method.invoke(exam, args);
//						//---기존 업무-----------------------------------------------------
//						
//						long end = System.currentTimeMillis();
//						String message = (end - start) + "ms";
//						
//						System.out.println(message);
//						
//						
//						return result;
//					}
//				});
			
	}
}