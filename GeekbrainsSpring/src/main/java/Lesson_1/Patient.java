package Lesson_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Patient {

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Hospital hospital1 = context.getBean("Registry", Hospital.class);
		hospital1.giveInfo();

		Hospital hospital2 = context.getBean("Registry", Hospital.class);
		hospital2.giveInfo();
	}
}
